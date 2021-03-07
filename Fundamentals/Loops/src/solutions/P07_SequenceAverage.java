package solutions;
import java.util.Scanner;

public class P07_SequenceAverage 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		double number = scan.nextInt();
		double product = 1;
		int n = 0;
		
		while (number > 0)
		{
			product *= number;
			number = scan.nextInt();
			n++;
		}
		
		double avg = Math.pow(product, 1/(double)n);
		System.out.println("Geometric average = " + avg);
		scan.close();
	}
}
