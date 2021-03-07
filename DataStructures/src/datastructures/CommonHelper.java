package datastructures;

public class CommonHelper
{
	public static final String INDEX_OUT_OF_RANGE = "Index was out of range";
	
	private CommonHelper() { }
	
	public static <T> boolean areEqual(T first, T second)
	{
		return first == null && second == null || first != null && first.equals(second);
	}
	
	public static void throwIfIndexOutOfRange(int index, int size)
	{
		if (index < 0 || index >= size)
		{
			throw new IllegalArgumentException(INDEX_OUT_OF_RANGE);
		}
	}
}
