package solutions;
import java.util.Scanner;

public class P04_SecondBiggestNumber 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		int number = scan.nextInt();
		int max = number;
		int secondMax = -1;
		
		while (number >= 0)
		{
			if (number > max)
			{
				secondMax = max;
				max = number;
			}
			else if (number > secondMax)
			{
				secondMax = number;
			}
			
			number = scan.nextInt();
		}
		
		if (secondMax == -1)
		{
			System.out.println("There is not a second biggest number");
		}
		else
		{
			System.out.println("Second biggest = " + secondMax);
		}
		
		scan.close();
	}
}
