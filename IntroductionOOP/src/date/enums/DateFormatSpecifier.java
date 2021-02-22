package date.enums;

import helper.exceptions.ExceptionValidator;

public enum DateFormatSpecifier
{
	DAY("dd"),
	MONTH("MM"),
	YEAR("yyyy"),
	HOUR("hh"),
	MINUTE("mm"),
	SECOND("ss"),
	DAY_OF_WEEK("ww"),
	DATE_SEPARATOR("/"),
	TIME_SEPARATOR(":"),
	BASE_SEPARATOR(" ");
	
	private String specifierValue;
	
	private DateFormatSpecifier(String specifierValue)
	{
		this.setSpecifierValue(specifierValue);
	}
	
	private void setSpecifierValue(String value)
	{
		ExceptionValidator.throwIfNullOrEmpty(value, "specifierValue");
		this.specifierValue = value;
	}
	
	public String getSpecifierValue()
	{
		return this.specifierValue;
	}
	
	public String toString()
	{
		return this.getSpecifierValue();
	}
}
