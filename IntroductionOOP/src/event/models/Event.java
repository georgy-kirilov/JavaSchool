package event.models;

import date.enums.DateFormat;
import date.models.Date;
import helper.exceptions.ExceptionValidator;

public class Event 
{
	private String name;
	private Date date;
	
	public Event(String name, Date date)
	{
		this.setName(name);
		this.setDate(date);
	}
	
	public String getName()
	{
		return this.name;
	}
	
	private void setName(String value)
	{
		ExceptionValidator.throwIfNullOrEmpty(value, "name");
		this.name = value;
	}
	
	public Date getDate()
	{
		return this.date;
	}
	
	private void setDate(Date value)
	{
		ExceptionValidator.throwIfNull(value, "date");
		this.date = value;
	}
	
	public String toString()
	{
		StringBuilder output = new StringBuilder();
		
		output.append(this.getDate()
				.toString(DateFormat.EVENT));
		
		output.append(" - ");
		output.append(this.getName());
		
		return output.toString();
	}
}
