package lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P02_Palindrome
{
	public static void main(String[] args)
	{
		try (Scanner in = new Scanner(System.in))
		{
			long number = Long.parseLong(in.nextLine());
			List<Integer> digits = new ArrayList<>();
			
 			while (number != 0)
			{
				digits.add((int)(number % 10));
				number /= 10;
			}
 			
 			String output = "The number is a palindrome";
 			
 			for (int i = 0; i < digits.size() / 2; i++)
 			{
 				if (digits.get(i) != digits.get(digits.size() - 1 - i))
 				{
 					output = "The number is not a palirome";
 				}
 			}
 			
 			System.out.println(output);
		}
	}
}
