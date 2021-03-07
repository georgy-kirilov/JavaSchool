package solutions;
import java.util.Scanner;

public class P04_MissingNumber {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		byte a = scan.nextByte();
		byte b = scan.nextByte();
		byte c = scan.nextByte();
		int x = 0;
		
		boolean hasMissing = true;
		
		if (a == 0) {
			x = c - b;
		}
		else if (b == 0) {
			x = c - a;
		}
		else if (c == 0) {
			x = a + b;
		}
		else {
			System.out.println("There is NOT a missing number");
			hasMissing = false;
		}
		
		if (hasMissing) {
			System.out.println("The missing number is " + x);			
		}
		
		scan.close();
	}
}
