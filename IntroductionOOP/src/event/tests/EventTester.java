package event.tests;

import date.models.Date;
import event.models.Event;

public class EventTester 
{
	public static void main(String[] args)
	{
		Event event = new Event("Christmas", new Date(2020, 12, 25));
		System.out.println(event);
		
		// throws exception
		event = new Event("New Year's Eve", null);
	}
}
