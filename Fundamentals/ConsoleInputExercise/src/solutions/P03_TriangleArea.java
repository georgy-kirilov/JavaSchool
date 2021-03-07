package solutions;
import java.util.Scanner;

public class P03_TriangleArea {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		double a = scan.nextDouble();
		double b = scan.nextDouble();
		double c = scan.nextDouble();
		
		boolean sidesInValidRange = a > 0 && b > 0 && c > 0;
		boolean triangleExists = a + b > c && a + c > b && c + b > a;
		
		if (sidesInValidRange && triangleExists) {
			double p = (a + b + c) / 2;
			double area = p * (p - a) * (p - b) * (p - c);
			area = Math.sqrt(area);
			area = Math.round(area * 100d) / 100d;
			System.out.println("Area = " + area + " square units");
		}
		else {
			System.out.println("Invalid input");
		}
		
		scan.close();
	}
}
