package solutions;
import java.util.Scanner;

public class P05_Palindrome {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int number = scan.nextInt();
		
		int a = number % 10, b = number / 10000;
		int c = (number / 10) % 10, d = (number / 1000) % 10;

		boolean isPalindrome = a == b && c == d;
		
		if (isPalindrome) {
			System.out.println("Palindrome");
		}
		else {
			System.out.println("NOT a palindrome");
		}

		scan.close();
	}
}
