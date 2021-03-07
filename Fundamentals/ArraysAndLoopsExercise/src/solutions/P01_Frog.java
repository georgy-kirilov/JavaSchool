package solutions;
import java.util.Scanner;

public class P01_Frog 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		int depth = scan.nextInt();
		int heightClimbed = 0, daysCount = 0;
		
		while (heightClimbed < depth)
		{
			heightClimbed += 3;
			daysCount++;
			
			if (daysCount % 2 == 0)
			{
				heightClimbed--;
			}
			
			System.out.println("Day #" + daysCount + ": " + heightClimbed + " meters");
		}
		
		System.out.println("Total days: " + daysCount);
		scan.close();
	}
}
