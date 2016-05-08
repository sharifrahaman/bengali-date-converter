package com.softdaemon.bangla.date.converter;

/**
 * Then ENUM represent seven days of week (SUNDAY[রবিবার] to SATURDAY[শনিবার])
 * @author sharif
 *
 */
public enum DayOfWeek {
	SUNDAY("রবিবার"),
	MONDAY("সোমবার"),
	TUESDAY("মঙ্গলবার"),
	WEDNESDAY("বুধবার"),
	THURSDAY("বৃহস্পতিবার"),
	FRIDAY("শুক্রবার"),
	SATURDAY("শনিবার");
	
	private final String banglaName;
	
	DayOfWeek(String banglaName){
		this.banglaName = banglaName;
	}
	
	public String getBanglaName() {
		return banglaName;
	}
}
