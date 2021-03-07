package solutions;
import java.util.Scanner;

public class P10_MaxMatrixDiagonalElement
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter matrix size: ");
		int size = scan.nextInt();
		
		int[][] matrix = new int[size][size];
		
		for (int row = 0; row < matrix.length; row++)
		{
			for (int column = 0; column < matrix[0].length; column++)
			{
				System.out.print("[" + row + "][" + column + "] = ");
				matrix[row][column] = scan.nextInt();
			}
		}
		
		int leftRow = 0, leftColumn = 0, max = 0;
		
		while (leftRow < size && leftColumn < size)
		{
			int element = matrix[leftRow][leftColumn];
			
			if (leftRow == 0) 
			{				
				max = element;
			}
			else if (max < element)
			{
				max = element;
			}
			
			System.out.print(element + " ");
			
			leftRow++;
			leftColumn++;
		}
		
		System.out.println("\nMax diagonal element: " + max);
		scan.close();
	}
}
