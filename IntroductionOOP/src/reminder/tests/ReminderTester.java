package reminder.tests;

import reminder.models.*;
import event.models.*;
import date.models.*;

public class ReminderTester 
{
	public static void main(String[] args)
	{
		Event myBirthday = new Event("Georgi's birthday", new Date(2021, 6, 13));
		
		Event[] birthdays = new Event[]
		{
			myBirthday,
			new Event("Einstein's birthday", new Date(2021, 3, 14)),
			new Event("Ronaldo's birthday", new Date(2021, 3, 14)),
		};
		
		Reminder birthdayReminder = new Reminder(birthdays);
		birthdayReminder.addEvent(new Event("Some birthday", new Date(2020, 11, 4)));
		
		Event[] events = birthdayReminder.getAllEventsAt(new Date(2021, 3, 14));
		
		for (Event ev : events)
		{
			System.out.println(ev);
		}
		
		System.out.println("Events today:");
		birthdayReminder.remind();
		
		// Should throw exception
		birthdayReminder.addEvent(myBirthday);
	}
}
