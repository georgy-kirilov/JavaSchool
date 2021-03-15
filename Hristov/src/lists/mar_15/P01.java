package lists.mar_15;

import java.util.LinkedList;
import java.util.Scanner;

public class P01
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		String numberAsString = trimTrailingZeros(in.nextLine());
		
		LinkedList<Integer> digits = new LinkedList<>();

		for (int i = 0; i < numberAsString.length(); i++)
		{
			digits.add(numberAsString.charAt(i) - '0');
		}
		
		boolean equal = true;
		
		for (int i = 0; i < digits.size() / 2; i++)
		{
			if (digits.get(i) > digits.get(digits.size() - i - 1))
			{
				System.out.println("Regular order is larger");
				equal = false;
				break;
			}
			else if (digits.get(i) < digits.get(digits.size() - i - 1))
			{
				System.out.println("Reversed order is larger");
				equal = false;
				break;
			}
		}
		
		if (equal)
		{
			System.out.println("Both orders are equal");
		}
		
		in.close();
	}
	
	static String trimTrailingZeros(String numberAsString)
	{	
		int trailingZerosCount = 0;
		
		for (int i = numberAsString.length() - 1; i >= 0; i--)
		{
			if (numberAsString.charAt(i) != '0')
			{
				break;
			}
			else
			{
				trailingZerosCount++;
			}
		}
		
		int endIndex = numberAsString.length() - trailingZerosCount;
		return numberAsString.substring(0, endIndex);
	}
}
