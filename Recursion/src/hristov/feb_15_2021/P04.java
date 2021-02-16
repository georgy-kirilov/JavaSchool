package hristov.feb_15_2021;

import delegates.Action;

public class P04
{
	public static void main(String[] args)
	{
		printTriangleOfLetters('G');
	}
	
	static void printTriangleOfLetters(char lastLetter)
	{
		final char firstLetter = 'A';
		
		Action<Integer, Integer> action = new Action<Integer, Integer>()
		{
			@Override
			public void invoke(Integer row, Integer col)
			{
				if (row > lastLetter - firstLetter)
				{
					return;
				}
				
				System.out.print((char)(firstLetter + col));
				col++;
				
				if (col > lastLetter - firstLetter - row)
				{
					col = 0;
					row++;
					System.out.println();
				}
				
				this.invoke(row, col);
			}
		};
		
		action.invoke(0, 0);
	}
}
