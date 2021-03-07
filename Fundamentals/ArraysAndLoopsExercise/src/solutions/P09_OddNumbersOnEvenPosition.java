package solutions;
import java.util.Scanner;

public class P09_OddNumbersOnEvenPosition 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Enter size of the array: ");
		int n = scan.nextInt();
		
		int[] numbers = new int[n];
		
		for (int i = 0; i < numbers.length; i++)
		{
			System.out.print("[" + i + "] = ");
			numbers[i] = scan.nextInt();
		}
		
		for (int i = 0; i < numbers.length; i++)
		{
			if (i % 2 == 0 && numbers[i] % 2 != 0)
			{
				System.out.println("Position " + i + ": " + numbers[i]);
			}
		}
		
		scan.close();
	}
}
