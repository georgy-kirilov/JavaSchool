package solutions;
import java.util.Scanner;

public class P04_Squares 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt(), i = 1;
		
		while (i <= n)
		{
			int k = 1, square = 0;
			
			while (k <= i)
			{
				square += i;
				k++;
			}
			
			System.out.print(square);
			
			if (i != n)
				System.out.print(", ");
			
			i++;
		}
		
		scan.close();
	}
}
