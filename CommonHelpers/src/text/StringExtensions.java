package text;

public class StringExtensions
{
	private StringExtensions() { }
	
	public static <T> String join(String delimeter, Iterable<T> iterable)
	{
		StringBuilder sb = new StringBuilder();
		
		for (T item : iterable)
		{
			sb.append(item);
			sb.append(delimeter);
		}
		
		String result = sb.toString();
		result = result.length() == 0 ? result : result.substring(0, result.length() - delimeter.length());
		return result;
	}
}
