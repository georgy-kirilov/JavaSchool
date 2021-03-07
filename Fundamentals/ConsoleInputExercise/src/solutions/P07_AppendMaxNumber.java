package solutions;
import java.util.Scanner;

public class P07_AppendMaxNumber {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		String a = scan.nextLine();
		String b = scan.nextLine();
		String c = scan.nextLine();
		
		int n1 = Integer.parseInt(a + b + c);
		int n2 = Integer.parseInt(a + c + b);
		int n3 = Integer.parseInt(b + a + c);
		int n4 = Integer.parseInt(b + c + a);
		int n5 = Integer.parseInt(c + a + b);
		int n6 = Integer.parseInt(c + b + a);
		
		int max = n1;
		
		if (max < n2) max = n2;
		if (max < n3) max = n3;
		if (max < n4) max = n4;
		if (max < n5) max = n5;
		if (max < n6) max = n6;
		
		System.out.println("Max number: " + max);
		scan.close();
	}
}
