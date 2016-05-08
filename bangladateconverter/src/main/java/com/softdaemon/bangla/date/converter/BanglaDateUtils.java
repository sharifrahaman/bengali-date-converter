package com.softdaemon.bangla.date.converter;

import java.util.Calendar;
import java.util.EnumSet;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
/**
 * This is the core utility class to convert English to Bengali date and vice versa 
 * @author sharif
 *
 */
public class BanglaDateUtils {

	private static final Map<String, Date<BanglaMonth>> ENGLISH_TO_BANGLA_DATE;
	private static final Map<String, Date<EnglishMonth>> BANGLA_TO_ENGLISH_DATE;
	private static final EnglishMonth[] ENGLISH_MONTH;

	//Load static Map and Array for faster conversion
	static {
		ENGLISH_TO_BANGLA_DATE = new HashMap<>();
		BANGLA_TO_ENGLISH_DATE = new HashMap<>();
		ENGLISH_MONTH = EnglishMonth.values();
		
		Calendar start = GregorianCalendar.getInstance();
		start.set(Calendar.HOUR_OF_DAY, 0);
		start.set(Calendar.MINUTE, 0);
		start.set(Calendar.SECOND, 0);
		start.set(Calendar.MILLISECOND, 0);
		start.set(2014, 3, 14);

		Calendar end = GregorianCalendar.getInstance();
		end.set(Calendar.HOUR_OF_DAY, 0);
		end.set(Calendar.MINUTE, 0);
		end.set(Calendar.SECOND, 0);
		end.set(Calendar.MILLISECOND, 0);
		end.set(2015, 3, 14);

		Iterator<BanglaMonth> interatorBanglaMonth = EnumSet.allOf(BanglaMonth.class).iterator();
		BanglaMonth currentMonthName = interatorBanglaMonth.next();
		int currentDay = 1;

		//Start from April 14 of non-leap year because that 1st day of Bengali year
		while (start.before(end)) {
			
			ENGLISH_TO_BANGLA_DATE.put(start.get(GregorianCalendar.MONTH) + "/" + start.get(GregorianCalendar.DATE),
					Date.<BanglaMonth>newInstance().day(currentDay).month(currentMonthName));
			currentDay++;
			/* The first five months of the year from Bôishakh to Bhadrô will 
			 * consist of 31 days each */
			if (currentMonthName.ordinal() < 5 && currentDay > 31) {
				currentDay = 1;
				currentMonthName = interatorBanglaMonth.next();
			} else if (currentMonthName.ordinal() > 4 && currentDay > 30 && interatorBanglaMonth.hasNext()) {
				currentDay = 1;
				currentMonthName = interatorBanglaMonth.next();
			}
			start.add(GregorianCalendar.DATE, 1);
		}		
		
		//Now populate banglaToEnglishDate map based on englishToBanglaDate map for better performance
		Set<Entry<String, Date<BanglaMonth>>> englishToBanglaDateEntrySet = ENGLISH_TO_BANGLA_DATE.entrySet();
		Iterator<Entry<String, Date<BanglaMonth>>> englishToBanglaDateIterator = englishToBanglaDateEntrySet.iterator();
		while(englishToBanglaDateIterator.hasNext()){
			Entry<String, Date<BanglaMonth>> englishToBanglaDateEntry = englishToBanglaDateIterator.next();
			BANGLA_TO_ENGLISH_DATE.put(getEnglishToBanglaMapKey(englishToBanglaDateEntry.getValue()), 
					getEnglishToBanglaMapValue(englishToBanglaDateEntry.getKey()));
		}
		
		// Add leap year manually for Bangla
		ENGLISH_TO_BANGLA_DATE.put("1/29", Date.<BanglaMonth>newInstance().day(17).month(BanglaMonth.FALGUN));
		BANGLA_TO_ENGLISH_DATE.put("10/31", Date.<EnglishMonth>newInstance().day(15).month(EnglishMonth.MARCH));
		
	}
	
	private static String getEnglishToBanglaMapKey(Date<BanglaMonth> banglaDate) {		
		return banglaDate.getMonth().ordinal()+"/"+banglaDate.getDay();
	}
	
	private static Date<EnglishMonth> getEnglishToBanglaMapValue(String banglaToEnglishKey) {
		String []date = banglaToEnglishKey.split("/");		
		return Date.<EnglishMonth>newInstance().month(ENGLISH_MONTH[Integer.parseInt(date[0])]).day(Integer.parseInt(date[1]));
	}

	/**
	 * This method takes English date as parameter returns Bengali date
	 * @param year
	 * @param month
	 * @param day
	 * @return Date<BanglaMonth>
	 */
	public static Date<BanglaMonth> getBanglaDate(int year, int month, int day) {
		//As month in Map key is 0 based (0-11) 
		month--;
		
		int banglaDay, banglaYear;
		BanglaMonth banglaMonth;
		// Bangla calendar start from April 14, 593.
		int banglaYearStarted = 593;

		// Create key based of the provided date
		String key = month + "/" + day;

		/* Get Day from Map. If the date is between March 1 and March 14 
		 * then add 1 day to adjust with leap year*/
		if (BanglaDateUtils.isLeapYear(year)
				&& (month == 2 && day < 15)) {
			banglaDay = ENGLISH_TO_BANGLA_DATE.get(key).getDay() + 1;
		} else {
			banglaDay = ENGLISH_TO_BANGLA_DATE.get(key).getDay();
		}

		// Get Month Name from Map
		banglaMonth = ENGLISH_TO_BANGLA_DATE.get(key).getMonth();

		// Calculate Bangla Year from the English year.
		if (month < 3
				|| (month == 3 && day < 14)) {
			banglaYearStarted++;
		}
		banglaYear = year - banglaYearStarted;

		return Date.<BanglaMonth>newInstance().year(banglaYear).month(banglaMonth).day(banglaDay);
	}
	
	/**
	 * This method takes Bengali date as parameter returns English date
	 * @param banglaYear
	 * @param banglaMonth
	 * @param banglaDay
	 * @return Date<EnglishMonth>
	 */
	public static Date<EnglishMonth> getEnglishDate(int banglaYear, int banglaMonth, int banglaDay) {
		banglaMonth--;
		int englishDay, englishYear;
		EnglishMonth englishMonth;
		// Bangla calendar start from April 14, 593.
		int banglaYearStarted = 593;
		
		// Calculate English Year from the Bangla year.
		if (banglaMonth > 8
				|| (banglaMonth == 8 && banglaDay > 17)) {
			banglaYearStarted++;
		}
		englishYear = banglaYear + banglaYearStarted;

		// Create key based of the provided Bengali date
		String key = banglaMonth + "/" + banglaDay;
		
		englishDay = BANGLA_TO_ENGLISH_DATE.get(key).getDay();
		englishMonth = BANGLA_TO_ENGLISH_DATE.get(key).getMonth();		
		
		/* Get Day from Map. If the date is between March 1 and March 14 then 
		 * subtract 1 day to adjust with leap year*/
		if (BanglaDateUtils.isLeapYear(englishYear)
				&& (banglaMonth == 10 && banglaDay > 16)) {
			englishDay--;
			if(englishDay == 0){
				englishDay = 29;
				englishMonth = EnglishMonth.FEBRUARY;
			}
		}	

		return Date.<EnglishMonth>newInstance().year(englishYear).month(englishMonth).day(englishDay);
	}
	
	/**
	 * Returns true only if the provided year is leap year
	 * @param year
	 * @return
	 */
	public static boolean isLeapYear(int year) {
		return (year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0));
	}

}
