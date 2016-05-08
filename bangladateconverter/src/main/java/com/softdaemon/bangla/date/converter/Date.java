package com.softdaemon.bangla.date.converter;

/**
 * Date class is designed to hold the converted value of Bengali and English date 
 * @author sharif
 *
 * @param <T>
 */
public class Date<T>{
	
	private int day;	
	private T month;
	private int year;
	private DayOfWeek dayOfWeek;
	
	public static <T> Date<T> newInstance(){
		return new Date<T>();
	}
	
	public Date<T> year(int year){
		this.year = year;
		return this;
	}
	
	public Date<T> month(T month){
		this.month = month;
		return this;
	}
	
	public Date<T> day(int day){
		this.day = day;
		return this;
	}
	
	public Date<T> dayOfWeek(DayOfWeek dayOfWeek){
		this.dayOfWeek = dayOfWeek;
		return this;
	}

	public int getDay() {
		return day;
	}

	public T getMonth() {
		return month;
	}

	public int getYear() {
		return year;
	}
	
	public DayOfWeek getDayOfWeek(){
		return dayOfWeek;
	}

	@Override
	public String toString(){
		return String.format("%s %d, %d", month, day, year);
	}
}