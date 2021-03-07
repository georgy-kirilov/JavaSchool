package solutions;
import java.util.Scanner;

public class P11_MagicSquare 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter matrix size:");
		int size = scan.nextInt();
		
		int[][] matrix = new int[size][size];

		for (int row = 0; row < size; row++)
		{
			for (int col = 0; col < size; col++)
			{
				System.out.print("[" + row + "][" + col + "] = ");
				matrix[row][col] = scan.nextInt();
			}
		}
		
		int initialSum = 0, currentSum = 0;
		boolean magicSquareExists = true;
		
		for (int row = 0; row < size; row++)
		{
			currentSum = 0;
			
			for (int col = 0; col < size; col++)
			{
				currentSum += matrix[row][col];
				
				if (row == 0)
				{
					initialSum += matrix[row][col];
				}
			}
			
			if (initialSum != currentSum)
			{
				magicSquareExists = false;
				break;
			}
		}
		
		if (magicSquareExists)
		{
			for (int col = 0; col < size; col++)
			{
				currentSum = 0;
				
				for (int row = 0; row < size; row++)
				{
					currentSum += matrix[row][col];
				}
				
				if (initialSum != currentSum)
				{
					magicSquareExists = false;
					break;
				}
			}
		}
		
		if (magicSquareExists)
		{
			int row = 0, leftCol = 0, rightCol = size - 1;
			int diagonalSum = 0;
			
			currentSum = 0;
			
			while (row < size && leftCol < size && rightCol >= 0)
			{
				currentSum += matrix[row][leftCol];
				diagonalSum += matrix[row][rightCol];
				leftCol++;
				rightCol--;
				row++;
			}
			
			if (currentSum != initialSum || diagonalSum != initialSum)
			{
				magicSquareExists = false;
			}
		}

		if (magicSquareExists)
		{
			System.out.println("Magic square");
		}
		else
		{
			System.out.println("NOT a magic square");
		}
		
		scan.close();
	}
}
