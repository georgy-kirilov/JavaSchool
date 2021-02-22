package date.tests;

import date.enums.DateFormat;
import date.models.*;

public class DateTester 
{
	public static void main(String[] args)
	{
		Date date = new Date(2020, 12, 25, 13, 30, 0);
		System.out.println(date.toString(DateFormat.EXTENDED));
		System.out.println(date.toString(DateFormat.EVENT));
		System.out.println(date.toString(DateFormat.STANDARD));
		
		// Date should become 30/December/2020
		date.addDays(5);
		System.out.println(date);
		
		// Date should become 09/January/2021
		date.addDays(10);
		System.out.println(date);
		
		// Should be Saturday
		System.out.println(date.getDayOfWeek());
		
		Date[] dates = new Date[]
		{
			new Date(2020, 1, 1, 1, 30, 45),
			new Date(2000, 1, 1, 1, 30, 45),
			new Date(2000, 1, 1, 1, 30, 40),
			new Date(1993, 3, 3, 1, 30, 00),
			new Date(1878, 5, 6),
		};
		
		Date.sortDateArray(dates, true);
		
		System.out.println("Sorted dates:");
		System.out.println("Ascending");
		
		for (Date current : dates)
		{
			System.out.println(current.toString(DateFormat.EXTENDED));
		}
		
		Date.sortDateArray(dates, false);
		
		System.out.println("Descending");
		
		for (Date current : dates)
		{
			System.out.println(current.toString(DateFormat.EXTENDED));
		}
	}
}
