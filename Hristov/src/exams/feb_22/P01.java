package exams.feb_22;

public class P01
{
	public static void main(String[] args)
	{
		int initialSize = 5;
		printTriangle(initialSize, initialSize, 1);
	}
	
	static void printTriangle(int initialSize, int cols, int number)
	{
		if (cols == 0)
		{
			return;
		}
		
		if (number > cols)
		{
			System.out.println();
			number = 0;
			cols--;
		}
		else
		{
			if (cols < initialSize && number != 1 && number != cols)
			{
				System.out.print("  ");
			}
			else
			{
				System.out.print(number + " ");
			}
		}
		
		printTriangle(initialSize, cols, number + 1);
	}
}
