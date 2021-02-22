package date.enums;

import helper.exceptions.ExceptionValidator;

public enum DayOfWeek 
{
	MONDAY(1),
	TUESDAY(2),
	WEDNESDAY(3),
	THURSDAY(4),
	FRIDAY(5),
	SATURDAY(6),
	SUNDAY(7);
	
	private int value;
	
	private DayOfWeek(int value)
	{
		this.value = value;
	}
	
	public int getValue()
	{
		return this.value;
	}
	
	public String toString()
	{
		switch (this.value)
		{
			case 1: 
				return "Monday";
			case 2: 
				return "Tuesday";
			case 3: 
				return "Wednesday";
			case 4: 
				return "Thursday";
			case 5: 
				return "Friday";
			case 6: 
				return "Saturday";
			case 7: 
				return "Sunday";
		}
		
		return null;
	}
	
	public String toString(int numberOfLetters)
	{
		ExceptionValidator.throwIfOutOfRange
			(numberOfLetters, 0, this.toString().length(), "numberOfLetters");
		
		return this.toString().substring(0, numberOfLetters);
	}
	
	public static DayOfWeek getDayOfWeekByIndex(int index)
	{
		switch(index)
		{
			case 1: 
				return DayOfWeek.MONDAY;
			case 2: 
				return DayOfWeek.TUESDAY;
			case 3: 
				return DayOfWeek.WEDNESDAY;
			case 4: 
				return DayOfWeek.THURSDAY;
			case 5: 
				return DayOfWeek.FRIDAY;
			case 6: 
				return DayOfWeek.SATURDAY;
			case 7: 
				return DayOfWeek.SUNDAY;
		}
		
		return null;
	}
}
