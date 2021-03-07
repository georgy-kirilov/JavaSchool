package solutions;
import java.util.Scanner;

public class P02_PrintTree 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int height = 2 * n + 1;
		int treeWidth = 3, rowWidth = n;
		
		for (int row = 1; row <= height; row++)
		{
			if (row % 2 != 0)
			{
				for (int col = 1; col < n + 1; col++)
				{
					System.out.print(" ");
				}
				
				System.out.print("*");
			}
			else
			{
				for (int col = 1; col < rowWidth; col++)
				{
					System.out.print(" ");
				}
				
				for (int col = 1; col <= treeWidth; col++)
				{
					System.out.print("*");
				}
				
				treeWidth += 2;
				rowWidth--;
			}
			
			System.out.println();
		}

		scan.close();
	}
}
