package solutions;
import java.util.Scanner;

public class P02_AnotherPointPosition {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		double x = scan.nextDouble();
		double y = scan.nextDouble();
		
		boolean insideFigure = x >= 2 && x <= 3 && y >= 2 && y <= 6 ||
							   x >= 3 && x <= 5 && y >= 3 && y <= 5 ||
							   x >= 5 && x <= 6 && y >= 2 && y <= 6;
							   
		if (insideFigure) {
			System.out.println("The point is inside the figure");
		}
		else {
			System.out.println("The point is outside the figure");
		}
		
		boolean onFigureBorder = (x == 2 || x == 6) && (y >= 2 && y <= 6) ||
								(y == 2 || y == 6) && (x >= 2 && x <= 3 || x >= 5 && x <= 6) ||
								(x == 3 || x == 5) && (y >= 2 && y <= 3 || y >= 5 && y <= 6) ||
								(y == 3 || y == 5) && (x >= 3 && x <= 5);
		
		if (onFigureBorder) {
			System.out.println("The point is on the figure border");
		}
		else {
			System.out.println("The point is not on the figure border");
		}
		
		scan.close();
	}
}
