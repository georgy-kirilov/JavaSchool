package solutions;
import java.util.Scanner;

public class P06_MaxDigitSum {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int b = scan.nextInt();
		int c = scan.nextInt();
		int sumA = Math.abs(a) / 10 + Math.abs(a) % 10;
		int sumB = Math.abs(b) / 10 + Math.abs(b) % 10;
		int sumC = Math.abs(c) / 10 + Math.abs(c) % 10;
		
		boolean moreThanOne = (sumA == sumB && sumA >= sumC) || 
							  (sumA == sumC && sumA >= sumB) || 
							  (sumB == sumC && sumB >= sumA);
		
		if (moreThanOne) {
			System.out.println("More than one");
		}
		else if (sumA > sumB && sumA > sumC) {
			System.out.println(a);
		}
		else if (sumB > sumA && sumB > sumC) {
			System.out.println(b);
		}
		else if (sumC > sumA && sumC > sumB) {
			System.out.println(c);
		}
		
		scan.close();
	}
}
