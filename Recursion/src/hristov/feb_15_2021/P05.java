package hristov.feb_15_2021;

import delegates.BigAction;

public class P05
{
	public static void main(String[] args)
	{
		printTriangleOfNumbers(3, 9);
		printTriangleOfNumbers(1, 5);
		printTriangleOfNumbers(10, 15);
	}
	
	static void printTriangleOfNumbers(int cols, int rows)
	{	
		BigAction<Integer, Integer, Integer> action = new BigAction<Integer, Integer, Integer>()
		{	
			@Override
			public void invoke(Integer cols, Integer rows, Integer col)
			{
				if (col >= cols + 1)
				{
					col = 1;
					cols++;
					System.out.println();
				}
				
				if (cols >= rows + 1)
				{
					System.out.println();
					return;
				}
				
				System.out.print(col);
				col++;
				
				this.invoke(cols, rows, col);
			}
		};
		
		action.invoke(cols, rows, 1);
	}
}
