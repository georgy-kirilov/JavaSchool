package helper.exceptions;

public class ExceptionValidator 
{	
	public static <T extends Comparable<T>> void throwIfOutOfRange(T actual, T min, T max, String paramName)
	{	
		try
		{
			throwIfSmallerThan(actual, min, paramName);
			throwIfLargerThan(actual, max, paramName);
		}
		catch (Exception ex)
		{
			if (ex.getClass() == NullPointerException.class)
				throw ex;
			
			String message = String.format
					(ExceptionMessagesFormats.OUT_OF_RANGE, paramName, min, max);
			
			throw new RuntimeException(message);
		}
	}
	
	public static <T extends Comparable<T>> void throwIfSmallerThan(T actual, T min, String paramName)
	{
		throwIfNull(actual, "actual");
		throwIfNull(min, "min");
		
		boolean isSmaller = actual.compareTo(min) < 0;
		
		if (isSmaller)
		{
			String message = String.format
					(ExceptionMessagesFormats.SMALLER_THAN, paramName, min);
			
			throw new RuntimeException(message);
		}
	}
	
	public static <T extends Comparable<T>> void throwIfLargerThan(T actual, T max, String paramName)
	{
		throwIfNull(actual, "actual");
		throwIfNull(max, "max");
		
		boolean isLarger = actual.compareTo(max) > 0;
		
		if (isLarger)
		{
			String message = String.format
					(ExceptionMessagesFormats.LARGER_THAN, paramName, max);
			
			throw new RuntimeException(message);
		}
	}
	
	public static void throwIfNullOrEmpty(String str, String paramName)
	{
		throwIfNull(str, paramName);
		throwIfEmpty(str, paramName);
	}
	
	public static void throwIfNull(Object obj, String paramName)
	{
		if (obj == null)
		{
			String message = String.format
					(ExceptionMessagesFormats.CANNOT_BE_NULL, paramName);
			
			throw new NullPointerException(message);
		}
	}
	
	public static void throwIfEmpty(String str, String paramName)
	{
		if (str.length() == 0)
		{
			String message = String.format
					(ExceptionMessagesFormats.CANNOT_BE_EMPTY, paramName);
			
			throw new RuntimeException(message);
		}
	}
}
