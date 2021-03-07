package solutions;
import java.util.Scanner;

public class P07_DifferenceOfBiggestAndSmallest {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int b = scan.nextInt();
		int difference = a - b;
		difference = difference < 0 ? difference * -1 : difference;		
		System.out.println(difference);
		scan.close();
	}
}
