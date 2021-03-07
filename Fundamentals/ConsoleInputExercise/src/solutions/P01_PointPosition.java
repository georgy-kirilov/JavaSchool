package solutions;
import java.util.Scanner;

public class P01_PointPosition {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		double x = scan.nextDouble();
		double y = scan.nextDouble();
		
		boolean insideFigure = x >= 1 && x <= 2 && y >= 0 && y <= 1 || 
								x >= 2 && x <= 6 && y >= 0 && y <= 4;
		
		if (insideFigure) {
			System.out.println("The point is inside the figure");
		}
		else {
			System.out.println("The point is outside the figure");
		}
		
		boolean onFigureBorder = x == 1 && y <= 1 && y >= 0 ||
									y == 1 && x >= 1 && x <= 2 ||
									x == 2 && y >= 1 && y <= 4 ||
									y == 4 && x >= 2 && x <= 6 ||
									x == 6 && y >= 0 && y <=4;
									
		if (onFigureBorder) {
			System.out.println("The point is on the figure border");
		}
		else {
			System.out.println("The point is not on the figure border");
		}
		
		scan.close();
	}
}