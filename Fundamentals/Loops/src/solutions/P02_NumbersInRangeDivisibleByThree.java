package solutions;
import java.util.Scanner;

public class P02_NumbersInRangeDivisibleByThree 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int b = scan.nextInt();
		int start = (a < b ? a : b) + 1;
		int end = (a > b ? a : b) - 1;
		
		for(int i = start; i <= end; i++) 
		{
			if (i % 3 == 0)
				System.out.println(i);
		}
		
		scan.close();
	}
}
