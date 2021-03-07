package solutions;
import java.util.Scanner;

public class P02_MinAndMaxInArray 
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Enter array length: ");
		int count = scan.nextInt();
		
		double[] numbers = new double[count];
		double min = 0, max = 0;
		
		for (int i = 0; i < numbers.length; i++)
		{
			System.out.print("[" + i + "] = ");
			numbers[i] = scan.nextDouble();
			
			if (i == 0)
			{
				min = numbers[0];
				max = numbers[0];
			}
			else
			{
				if (min > numbers[i]) 
				{
					min = numbers[i];
				}
				
				if (max < numbers[i])
				{
					max = numbers[i];
				}
			}
		}

		System.out.println("Largest distance is between " + min + " and " + max);
		scan.close();
	}
}
