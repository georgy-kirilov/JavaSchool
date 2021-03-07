package solutions;
import java.util.Scanner;

public class P05_SameDigits {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int number = scan.nextInt();
		int a = number % 10;
		number /= 10;
		int b = number % 10;
		number /= 10;
		int c = number % 10;
		number /= 10;
		int d = number % 10;
		
		boolean allDigitsDifferent = a != b && a != c && a != d 
										&& b != c && b != d && c != d;
		
		if (allDigitsDifferent) {
			System.out.println("All digits are different");
		}
		else {
			System.out.println("There are same digits in the number");
		}
		
		scan.close();
	}
}