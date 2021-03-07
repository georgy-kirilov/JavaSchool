package solutions;
import java.util.Scanner;

public class P02_DivisionOfThreeAndFive {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int number = scan.nextInt();
		String output = "";
		
		if (number % 3 == 0) {
			output += "papagal";
		}
		
		if (number % 5 == 0) {
			output += "chocho";
		}
		
		System.out.println(output);
		scan.close();
	}
}
