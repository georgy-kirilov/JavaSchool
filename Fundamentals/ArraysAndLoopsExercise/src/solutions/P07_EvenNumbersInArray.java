package solutions;
import java.util.Scanner;

public class P07_EvenNumbersInArray 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		int n = 10, start = scan.nextInt(), end = scan.nextInt();
		int[] numbers = new int[n];
		
		for (int i = 0; i < numbers.length; i++)
		{
			numbers[i] = scan.nextInt();
		}
		
		for (int i = 0; i < numbers.length; i++)
		{
			if (numbers[i] % 2 == 0 && numbers[i] >= start && numbers[i] <= end)
			{
				System.out.print(numbers[i] + " ");
			}
		}
		
		scan.close();
	}
}
