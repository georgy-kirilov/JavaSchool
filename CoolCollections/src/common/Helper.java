package common;

public class Helper
{
	private Helper() { }
	
	public static <T> boolean areEqual(T first, T second)
	{
		return first == null && second == null || first != null && first.equals(second);
	}
}
