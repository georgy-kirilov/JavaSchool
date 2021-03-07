package solutions;
import java.util.Scanner;

public class P01_EqualPairs {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int b = scan.nextInt();
		int c = scan.nextInt();
		int d = scan.nextInt();
		
		boolean equalPairsPossible = a + b == c + d ||
									 a + c == b + d ||
									 a + d == b + c;
		
		if (equalPairsPossible) {
			System.out.println("Equal pairs are possible");
		}
		else {
			System.out.println("Equal pairs are impossible");
		}
		
		scan.close();
	}
}
