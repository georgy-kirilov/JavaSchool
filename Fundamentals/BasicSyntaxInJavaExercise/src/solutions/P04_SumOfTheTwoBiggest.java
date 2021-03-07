package solutions;
import java.util.Scanner;

public class P04_SumOfTheTwoBiggest {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int b = scan.nextInt();
		int c = scan.nextInt();
		int d = scan.nextInt();
		int biggest = a;
		
		if (biggest < b)
			biggest = b;
		
		if (biggest < c)
			biggest = c;
		
		if (biggest < d) 
			biggest = d;
		
		int secondBiggest = a;
		
		if ((b < biggest && secondBiggest < b) || secondBiggest == biggest)
			secondBiggest = b;
			
		if ((c < biggest && secondBiggest < c) || secondBiggest == biggest)
			secondBiggest = c;
		
		if ((d < biggest && secondBiggest < d) || secondBiggest == biggest)
			secondBiggest = d;
		
		System.out.println("The biggest sum is of " + biggest + " and " + secondBiggest);
		scan.close();
	}
}

