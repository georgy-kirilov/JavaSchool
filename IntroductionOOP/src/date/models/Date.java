package date.models;

import date.enums.*;
import helper.exceptions.ExceptionValidator;
import helper.StringExtensions;

public class Date 
{
	public static final int WEEK_DAYS_COUNT = 7;
	
	private static final int SECONDS_MIN_VALUE = 0;
	private static final int SECONDS_MAX_VALUE = 59;
	private static final int MINUTES_MIN_VALUE = 0;
	private static final int MINUTES_MAX_VALUE = 59;
	private static final int HOURS_MIN_VALUE = 0;
	private static final int HOURS_MAX_VALUE = 23;
	private static final int DAYS_MIN_VALUE = 1;
	private static final int MONTHS_MIN_VALUE = 1;
	private static final int MONTHS_MAX_VALUE = 12;
	private static final int YEARS_MIN_VALUE = 0;
	private static final int YEARS_MAX_VALUE = 9999;
	
	private int second;
	private int minute;
	private int hour;
	private int day;
	private int month;
	private int year;
	
	private DayOfWeek firstJanuaryAsDayOfWeek;
	
	// Most commonly used date format
	public Date(int year, int month, int day)
	{
		this.setYear(year);
		this.setMonth(month);
		this.setDay(day);
		
		// Determines which day of the week is January the 1st
		this.setFirstJanuaryAsDayOfWeek
			(getDayOfWeekByGivenDate(this.getYear(), 1, 1));
	}
	
	// Extended format for more precise date and time management
	public Date(int year, int month, int day, int hour, int minute, int second)
	{
		this(year, month, day);
		this.setHour(hour);
		this.setMinute(minute);
		this.setSecond(second);
	}
	
	public int getSecond()
	{ 
		return this.second; 
	}
	
	public void setSecond(int value)
	{
		ExceptionValidator.throwIfOutOfRange
			(value, SECONDS_MIN_VALUE, SECONDS_MAX_VALUE, "second");
		
		this.second = value;
	}
	
	public int getMinute()
	{ 
		return this.minute; 
	}
	
	public void setMinute(int value)
	{
		ExceptionValidator.throwIfOutOfRange
			(value, MINUTES_MIN_VALUE, MINUTES_MAX_VALUE, "minute");

		this.minute = value;
	}
	
	public int getHour()
	{ 
		return this.hour; 
	}
	
	public void setHour(int value)
	{
		ExceptionValidator.throwIfOutOfRange
			(value, HOURS_MIN_VALUE, HOURS_MAX_VALUE, "hour");
		
		this.hour = value;
	}
	
	public int getDay()
	{ 
		return this.day; 
	}
	
	public void setDay(int value)
	{
		int daysMaxValue = getDaysInMonthCount(this.getMonth(), this.getYear());
		
		ExceptionValidator.throwIfOutOfRange
			(value, DAYS_MIN_VALUE, daysMaxValue, "day");
		
		this.day = value;
	}
	
	public int getMonth()
	{ 
		return this.month; 
	}
	
	public void setMonth(int value)
	{
		ExceptionValidator.throwIfOutOfRange
			(value, MONTHS_MIN_VALUE, MONTHS_MAX_VALUE, "month");
		
		this.month = value;
	}
	
	public int getYear()
	{ 
		return this.year; 
	}
	
	public void setYear(int value)
	{
		ExceptionValidator.throwIfOutOfRange
			(value, YEARS_MIN_VALUE, YEARS_MAX_VALUE, "year");
		
		this.year = value;
	}
	
	public DayOfWeek getFirstJanuaryAsDayOfWeek()
	{
		return this.firstJanuaryAsDayOfWeek;
	}
	
	public void setFirstJanuaryAsDayOfWeek(DayOfWeek value)
	{
		ExceptionValidator.throwIfNull(value, "firstJanuaryAsDayOfWeek");
		
		this.firstJanuaryAsDayOfWeek = value;
	}
	
	public boolean isYearLeap()
	{
		return isYearLeap(this.getYear());
	}
	
	public DayOfWeek getDayOfWeek()
	{
		DayOfWeek dayOfWeek = getDayOfWeekByGivenDate
					(this.getYear(), this.getMonth(), this.getDay());
		
		return dayOfWeek;
	}
	
	public int getDayNumber()
	{
		int dayNumber = 0;
		
		for (int month = MONTHS_MIN_VALUE; month <= this.getMonth() - 1; month++)
		{
			dayNumber += getDaysInMonthCount(month, this.getYear());
		}
		
		dayNumber += this.getDay();
		return dayNumber;
	}
	
	public int getWeekNumber()
	{
		int firstJanuaryWeekIndex = this.getFirstJanuaryAsDayOfWeek().getValue();
		
		ExceptionValidator.throwIfOutOfRange
			(firstJanuaryWeekIndex, 1, WEEK_DAYS_COUNT, "firstJanuaryAsDayOfWeek");
		
		int totalDays = this.getDayNumber() + firstJanuaryWeekIndex - 1;
		int weekNumber = totalDays / WEEK_DAYS_COUNT;
		
		if (totalDays % WEEK_DAYS_COUNT != 0)
			weekNumber++;
		
		return weekNumber;
	}
	
	public int compareTo(Date date)
	{
		ExceptionValidator.throwIfNull(date, "date");
		
		int difference = this.compareYears(date);
		
		if (difference != 0)
			return difference;
		
		difference = this.compareMonths(date);
		
		if (difference != 0)
			return difference;
		
		difference = this.compareDays(date);
		
		if (difference != 0)
			return difference;
		
		difference = this.compareHours(date);
		
		if (difference != 0) 
			return difference;
		
		difference = this.compareMinutes(date);
		
		if (difference != 0)
			return difference;
		
		difference = this.compareSeconds(date);
		
		return difference;	
	}
	
	public int compareYears(Date date)
	{
		ExceptionValidator.throwIfNull(date, "date");
		
		return Integer.compare(this.getYear(), date.getYear());
	}
	
	public int compareMonths(Date date)
	{
		ExceptionValidator.throwIfNull(date, "date");
		
		return Integer.compare(this.getMonth(), date.getMonth());
	}
	
	public int compareDays(Date date)
	{
		ExceptionValidator.throwIfNull(date, "date");
		
		return Integer.compare(this.getDay(), date.getDay());
	}
	
	public int compareHours(Date date)
	{
		ExceptionValidator.throwIfNull(date, "date");
		
		return Integer.compare(this.getHour(), date.getHour());
	}
	
	public int compareMinutes(Date date)
	{
		ExceptionValidator.throwIfNull(date, "date");
		
		return Integer.compare(this.getMinute(), date.getMinute());
	}
	
	public int compareSeconds(Date date)
	{
		ExceptionValidator.throwIfNull(date, "date");
		
		return Integer.compare(this.getSecond(), date.getSecond());
	}
	
	// TODO: Implement methods for time subtraction
	
	public void addSeconds(int secondsToAdd)
	{
		ExceptionValidator.throwIfSmallerThan(secondsToAdd, 0, "secondsToAdd");
		
		int totalSeconds = this.getSecond() + secondsToAdd;
		int secondsInOneMin = 60;
		
		this.setSecond(totalSeconds % secondsInOneMin);
		
		if (totalSeconds > SECONDS_MAX_VALUE)
			this.addMinutes(totalSeconds / secondsInOneMin);
	}
	
	public void addMinutes(int minutesToAdd)
	{
		ExceptionValidator.throwIfSmallerThan(minutesToAdd, 0, "minutesToAdd");
		
		int totalMinutes = this.getMinute() + minutesToAdd;
		int minutesInOneHour = 60;
		
		this.setMinute(totalMinutes % minutesInOneHour);
		
		if (totalMinutes > MINUTES_MAX_VALUE)
			this.addHours(totalMinutes / minutesInOneHour);
	}
	
	public void addHours(int hoursToAdd)
	{
		ExceptionValidator.throwIfSmallerThan(hoursToAdd, 0, "hoursToAdd");
		
		int totalHours = this.getHour() + hoursToAdd;
		int hoursInOneDay = 24;
		
		this.setHour(totalHours % hoursInOneDay);
		
		if (totalHours > HOURS_MAX_VALUE)
			this.addDays(totalHours / hoursInOneDay);
	}
	
	public void addDays(int daysToAdd)
	{
		ExceptionValidator.throwIfSmallerThan(daysToAdd, 0, "daysToAdd");
		
		int totalDays = this.getDay() + daysToAdd;
		int currentMonth = this.getMonth();
		int daysInOneMonth = getDaysInMonthCount(currentMonth, this.getYear());
		boolean firstLoop = true;
		
		while (totalDays > daysInOneMonth)
		{
			this.addMonths(1);
			
			if (!firstLoop)
			{
				totalDays -= daysInOneMonth - this.getDay() + 1;						
			}
			else
			{
				firstLoop = false;
				totalDays = daysToAdd - daysInOneMonth + this.getDay();
				this.setDay(DAYS_MIN_VALUE);
			}

			currentMonth++;
			
			if (currentMonth > MONTHS_MAX_VALUE)
				currentMonth = MONTHS_MIN_VALUE;
			
			daysInOneMonth = getDaysInMonthCount(currentMonth, this.getYear());
		}
		
		this.setDay(totalDays);
	}
	
	public void addMonths(int monthsToAdd)
	{
		ExceptionValidator.throwIfSmallerThan(monthsToAdd, 0, "monthsToAdd");
		
		int totalMonths = this.getMonth() + monthsToAdd;
		int monthsInOneYear = 12;
		
		if (totalMonths > MONTHS_MAX_VALUE)
		{
			this.setMonth(totalMonths % monthsInOneYear);
			this.addYears(totalMonths / monthsInOneYear);
		}
		else
		{
			this.setMonth(totalMonths);
		}
	}
	
	public void addYears(int yearsToAdd)
	{
		ExceptionValidator.throwIfSmallerThan(yearsToAdd, 0, "yearsToAdd");
		
		int newYearValue = this.getYear() + yearsToAdd;
		this.setYear(newYearValue);
	}
	
	public String toString(DateFormat format)
	{	
		ExceptionValidator.throwIfNull(format, "format");
		
		String result = format.toString();
		
		char paddingSymbol = '0';
		int twoDigitLength = 2;
		
		String year = Integer.toString(this.getYear());
		
		String month = getMonthNameByNumber(this.getMonth());
		
		String day = StringExtensions.padLeft
				(Integer.toString(this.getDay()), twoDigitLength, paddingSymbol);
		
		String hour = StringExtensions.padLeft
				(Integer.toString(this.getHour()), twoDigitLength, paddingSymbol);
		
		String minute = StringExtensions.padLeft
				(Integer.toString(this.getMinute()), twoDigitLength, paddingSymbol);
		
		String second = StringExtensions.padLeft
				(Integer.toString(this.getSecond()), twoDigitLength, paddingSymbol);
		
		result = result.replace
				(DateFormatSpecifier.DAY.getSpecifierValue(), day);
		
		result = result.replace
				(DateFormatSpecifier.MONTH.getSpecifierValue(), month);
		
		result = result.replace
				(DateFormatSpecifier.YEAR.getSpecifierValue(), year);
		
		result = result.replace
				(DateFormatSpecifier.HOUR.getSpecifierValue(), hour);
		
		result = result.replace
				(DateFormatSpecifier.MINUTE.getSpecifierValue(), minute);
		
		result = result.replace
				(DateFormatSpecifier.SECOND.getSpecifierValue(), second);
	
		result = result.replace
				(DateFormatSpecifier.DAY_OF_WEEK.getSpecifierValue(), 
				 this.getDayOfWeek().toString());
		
		return result;
	}
	
	public String toString()
	{
		String result = this.toString(DateFormat.STANDARD);
		return result;
	}
	
	public static boolean isYearLeap(int year)
	{
		ExceptionValidator.throwIfOutOfRange
			(year, YEARS_MIN_VALUE, YEARS_MAX_VALUE, "year");
		
		if (year % 4 != 0) return false;
		else if (year % 25 != 0) return true;
		else if (year % 16 != 0) return false;
		
		return true;
	}
	
	public static int getDaysInMonthCount(int month, int year)
	{	
		ExceptionValidator.throwIfOutOfRange
			(month, MONTHS_MIN_VALUE, MONTHS_MAX_VALUE, "month");
		
		ExceptionValidator.throwIfOutOfRange
			(year, YEARS_MIN_VALUE, YEARS_MAX_VALUE, "year");
		
		boolean hasThirtyOneDays = month == 1 || month == 3 || month == 5 || month == 7 || 
								  month == 8 || month == 10 || month == 12;
		if (hasThirtyOneDays)
			return 31;
		
		else if (month != 2)
			return 30;
		
		else if (isYearLeap(year))
			return 29;
		
		return 28;
	}
	
	// TODO: Find a better way to get and format month names
	public static String getMonthNameByNumber(int month)
	{
		ExceptionValidator.throwIfOutOfRange
			(month, MONTHS_MIN_VALUE, MONTHS_MAX_VALUE, "month");
		
		String[] monthNames = new String[] 
		{
			"January", 
			"February", 
			"March",
			"April",
			"May", 
			"June",
			"July",
			"August",
			"September", 
			"October", 
			"November", 
			"Decemeber"
		};
		
		return monthNames[month - 1];
	}
	
	// TODO: Implement the sort method using a more efficient algorithm
	public static void sortDateArray(Date[] dates, boolean ascending)
	{
		ExceptionValidator.throwIfNull(dates, "dates");
		
		for (int i = 0; i < dates.length - 1; i++)
		{
			for (int k = i + 1; k < dates.length; k++)
			{
				boolean hasToSwap = dates[i].compareTo(dates[k]) > 0 && ascending ||
									dates[i].compareTo(dates[k]) < 0 && !ascending;
				if (hasToSwap)
				{
					Date temp = dates[i];
					dates[i] = dates[k];
					dates[k] = temp;
				}	
			}
		}
	}
	
	public static DayOfWeek getDayOfWeekByGivenDate(int year, int month, int day) 
	{	
		ExceptionValidator.throwIfOutOfRange
			(year, YEARS_MIN_VALUE, YEARS_MAX_VALUE, "year");
		
		ExceptionValidator.throwIfOutOfRange
			(month, MONTHS_MIN_VALUE, MONTHS_MAX_VALUE, "month");
		
		ExceptionValidator.throwIfOutOfRange
			(day, DAYS_MIN_VALUE, getDaysInMonthCount(month, year), "day");
		
		int yearCode = calculateYearCode(year);
		int monthCode = calculateMonthCode(month);
		int centuryCode = calculateCenturyCode(year);
		
		int leapYearCode = 0;
		
		if (isYearLeap(year) && (month == 1 || month == 2))
		{
			leapYearCode = 1;
		}
		
		int dayOfWeekIndex = (yearCode + monthCode + centuryCode + day - leapYearCode) % 7;

		if (dayOfWeekIndex == 0)
		{
			dayOfWeekIndex = DayOfWeek.SUNDAY.getValue();
		}
		
		return DayOfWeek.getDayOfWeekByIndex(dayOfWeekIndex);
	}
	
	private static int calculateYearCode(int year)
	{
		ExceptionValidator.throwIfOutOfRange
			(year, YEARS_MIN_VALUE, YEARS_MAX_VALUE, "year");
		
		int lastTwoDigits = year % 1000 % 100;
		
		return (lastTwoDigits + (lastTwoDigits / 4)) % 7;
	}
	
	private static int calculateMonthCode(int month)
	{
		ExceptionValidator.throwIfOutOfRange
			(month, MONTHS_MIN_VALUE, MONTHS_MAX_VALUE, "month");
		
		int[] monthsCodes = new int[] { 0, 3, 3, 6, 1, 4, 6, 2, 5, 0, 3, 5 };
		
		return monthsCodes[month - 1];
	}
	
	private static int calculateCenturyCode(int year)
	{
		ExceptionValidator.throwIfOutOfRange
			(year, YEARS_MIN_VALUE, YEARS_MAX_VALUE, "year");
		
		int[] gregorianCenturiesCodes = new int[] { 6, 4, 2, 0 };
		
		int century = year / 100;
		
		if (century >= 17)
		{
			return gregorianCenturiesCodes[century % 4];
		}
		
		return (18 - century) % 7;
	}
}
