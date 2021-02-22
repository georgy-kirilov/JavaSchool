package exams.feb_22;

public class P02
{
	public static void main(String[] args)
	{
		String input = "ABCDZ";
		input = input.toUpperCase();
		int index = input.indexOf('Z');
		
		if (index == -1)
		{
			System.out.println("No 'Z' found");
		}
		else
		{
			reverseString(input.substring(0, index + 1), 0);			
		}
	}
	
	static void reverseString(String input, int index)
	{
		char current = input.charAt(index);
		if (index == input.length() - 1)
		{
			System.out.print(current);
			return;
		}
		reverseString(input, index + 1);
		System.out.print(current);
	}
}
