package solutions;
import java.util.Scanner;

public class P05_BiggestCommonDivisor 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int b = scan.nextInt();
		
		for (int div = a < b ? a : b; div >= 1; div--) 
		{
			if (a % div == 0 && b % div == 0) 
			{
				System.out.println("Greatest common divisor => " + div);
				break;
			}
		}
		
		scan.close();
	}
}
