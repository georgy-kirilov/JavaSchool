package solutions;
import java.util.Scanner;

public class P06_EulerFunction 
{
	public static void main(String[] args) 
	{
		Scanner scan =  new Scanner(System.in);
		int number = scan.nextInt();
		int count = 0;
		
		for (int i = 1; i < number; i++)
		{
			int gcd = 1;
			
			for (int div = i < number ? i : number; div >= 1; div--) 
			{
				if (i % div == 0 && number % div == 0) 
				{
					gcd = div;
					break;
				}
			}
			
			if (gcd == 1) count++;
		}
		
		System.out.println("g(" + number + ") = " + count);
		scan.close();
	}
}
