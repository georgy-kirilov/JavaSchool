package solutions;
import java.util.Scanner;

public class P05_DigitsOfSum 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		int numbersCount = 7, index = 0;
		int digitsCount = 0, sum = 0;
		
		while (index < numbersCount)
		{
			int element = scan.nextInt();
			
			if (element >= 0 && element <= 5000)
			{
				sum += element;
				index++;
			}
			else
			{
				System.out.println("Number was not in range");
			}
		}
		
		System.out.println("Sum of the numbers: " + sum);
		
		while (sum > 0)
		{
			sum /= 10;
			digitsCount++;
		}
		
		System.out.println("Digits count of the sum: " + digitsCount);
		scan.close();
	}
}
