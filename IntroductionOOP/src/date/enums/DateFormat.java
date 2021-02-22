package date.enums;

import helper.exceptions.ExceptionValidator;

public enum DateFormat
{
	STANDARD(new DateFormatSpecifier[] 
	{
		DateFormatSpecifier.DAY,
		DateFormatSpecifier.DATE_SEPARATOR,
		DateFormatSpecifier.MONTH,
		DateFormatSpecifier.DATE_SEPARATOR,
		DateFormatSpecifier.YEAR
	}),
	
	EXTENDED(new DateFormatSpecifier[] 
	{
		DateFormatSpecifier.DAY,
		DateFormatSpecifier.DATE_SEPARATOR,
		DateFormatSpecifier.MONTH,
		DateFormatSpecifier.DATE_SEPARATOR,
		DateFormatSpecifier.YEAR,
		DateFormatSpecifier.BASE_SEPARATOR,
		DateFormatSpecifier.HOUR,
		DateFormatSpecifier.TIME_SEPARATOR,
		DateFormatSpecifier.MINUTE,
		DateFormatSpecifier.TIME_SEPARATOR,
		DateFormatSpecifier.SECOND,
		DateFormatSpecifier.BASE_SEPARATOR,
		DateFormatSpecifier.DAY_OF_WEEK
	}),
	
	EVENT(new DateFormatSpecifier[] 
	{
		DateFormatSpecifier.DAY,
		DateFormatSpecifier.DATE_SEPARATOR,
		DateFormatSpecifier.MONTH,
		DateFormatSpecifier.DATE_SEPARATOR,
		DateFormatSpecifier.YEAR,
		DateFormatSpecifier.BASE_SEPARATOR,
		DateFormatSpecifier.HOUR,
		DateFormatSpecifier.TIME_SEPARATOR,
		DateFormatSpecifier.MINUTE
	});
	
	private DateFormatSpecifier[] specifiers;
	
	private DateFormat(DateFormatSpecifier[] specifiers)
	{
		this.setSpecifiers(specifiers);
	}
	
	private void setSpecifiers(DateFormatSpecifier[] value)
	{
		ExceptionValidator.throwIfNull(value, "specifiers");
		this.specifiers = value;
	}
	
	public String toString()
	{
		StringBuilder result = new StringBuilder();
		
		for (DateFormatSpecifier specifier : this.specifiers)
		{
			result.append(specifier);
		}
		
		return result.toString();
	}
}
