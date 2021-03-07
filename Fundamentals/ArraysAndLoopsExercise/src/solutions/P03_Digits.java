package solutions;
import java.util.Scanner;

public class P03_Digits 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		long number = scan.nextLong();
		int digitsCount = 0, digitsSum = 0;
		
		while (number > 0)
		{
			digitsSum += number % 10;
			number /= 10;
			digitsCount++;
		}
		
		System.out.println("Digits count: " + digitsCount);
		System.out.println("Digits sum: " + digitsSum);
		scan.close();
	}
}
