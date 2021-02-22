package helper;

public class StringExtensions 
{
	public static String padLeft(String inputString, int totalLength, char paddingSymbol)
	{
		return String.format("%1$" + totalLength + "s", inputString)
				     .replace(' ', paddingSymbol);
	}
}
