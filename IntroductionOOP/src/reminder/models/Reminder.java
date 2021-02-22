package reminder.models;

import date.models.Date;
import event.models.Event;
import helper.exceptions.ExceptionValidator;

import java.time.LocalDate;

public class Reminder 
{
	private static final int DEFAULT_INITIAL_CAPACITY = 30;
	
	private Event[] events;
	
	private int count;
	
	public Reminder()
	{
		this(DEFAULT_INITIAL_CAPACITY);
	}
	
	public Reminder(int initialCapacity)
	{
		ExceptionValidator.throwIfSmallerThan
				(initialCapacity, 1, "initialCapacity");
		
		this.events = new Event[initialCapacity];
		this.setCount(0);
	}
	
	public Reminder(Event[] events)
	{
		ExceptionValidator.throwIfNull(events, "events");
		
		ExceptionValidator.throwIfSmallerThan
				(events.length, 1, "length");
		
		int initialCapacity = events.length * 2;
		
		this.events = new Event[initialCapacity];
		this.setCount(events.length);
		
		for (int i = 0; i < events.length; i++)
		{
			this.setAt(i, events[i]);		
		}
	}

	public int getCount()
	{
		return this.count;
	}
	
	private void setCount(int value)
	{
		ExceptionValidator.throwIfOutOfRange
				(value, 0, this.getCapacity(), "count");
		
		this.count = value;
	}
	
	public void addEvent(Event newEvent)
	{
		ExceptionValidator.throwIfNull(newEvent, "newEvent");
		
		this.throwIfElementExists(newEvent);
		
		if (this.getCount() >= this.events.length)
		{
			this.expand();
		}
		
		this.setAt(this.getCount(), newEvent);
		
		int newCountValue = this.getCount() + 1;
		this.setCount(newCountValue);
	}
	
	public Event[] getAllEventsAt(Date date)
	{
		ExceptionValidator.throwIfNull(date, "date");
		
		Event[] eventsOnTheGivenDate = new Event[this.getCount()];
		
		int index = 0;
		
		for (int i = 0; i < this.getCount(); i++)
		{
			Date current = this.events[i].getDate();
			
			boolean areDatesTheSame = current.compareYears(date) == 0 && 
					current.compareMonths(date) == 0 &&
					current.compareDays(date) == 0;
			
			if (areDatesTheSame)
			{
				eventsOnTheGivenDate[index] = this.events[i];
				index++;
			}
		}
		
		Event[] shrinkedEventsOnTheGivenDateArray = new Event[index];
		
		for (int i = 0; i < shrinkedEventsOnTheGivenDateArray.length; i++)
		{
			shrinkedEventsOnTheGivenDateArray[i] = eventsOnTheGivenDate[i];
		}
		
		return shrinkedEventsOnTheGivenDateArray;
	}
	
	// TODO: add dependencies for the IO functionality 
	// (e.g. OutputWriter base class or interface)
	
	public void remind()
	{
		LocalDate currentDate = LocalDate.now();
		
		Date today = new Date(currentDate.getYear(), 
							  currentDate.getMonthValue(), 
							  currentDate.getDayOfMonth());
		
		Event[] eventsToday = this.getAllEventsAt(today);
		
		for (Event event : eventsToday)
		{
			System.out.println(event);
		}
	}
	
	private void expand()
	{
		int newSize = this.getCapacity() * 2;
		Event[] eventsCopy = new Event[newSize];
		
		for (int i = 0; i < this.getCapacity(); i++)
		{
			eventsCopy[i] = this.events[i];
		}
		
		this.events = eventsCopy;
	}
	
	private int getCapacity()
	{
		return this.events.length;
	}
	
	private void setAt(int index, Event event)
	{	
		ExceptionValidator.throwIfOutOfRange
				(index, 0, this.getCapacity() - 1, "index");
		
		ExceptionValidator.throwIfNull(event, "event");
		
		this.throwIfElementExists(event);
		
		this.events[index] = event;
	}
	
	private void throwIfElementExists(Event element)
	{
		if (this.doesElementExists(element))
		{
			String message = "element already exists in the event collection";
			throw new RuntimeException(message);
		}
	}
	
	private boolean doesElementExists(Event element)
	{
		for (int i = 0; i < this.getCount(); i++)
		{
			Event current = this.events[i];
			if (current != null && current.equals(element))
				return true;
		}
		
		return false;
	}
}
