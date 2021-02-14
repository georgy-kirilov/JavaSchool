package solutions;

import actions.Action;

public class Problem_3
{
	public static void main(String[] args)
	{
		printDigitsFromLeft(561326);
		printDigitsFromLeft(-1910);
		printDigitsFromLeft(20488);
		printDigitsFromLeft(-9);
		printDigitsFromLeft(10);
	}
	
	static void printDigitsFromLeft(int number)
	{
		Action<String, Integer> action = new Action<String, Integer>()
		{
			@Override
			public void invoke(String numberAsString, Integer currentPosition)
			{
				if (currentPosition >= numberAsString.length())
				{
					System.out.println();
					return;
				}
				
				System.out.print(numberAsString.charAt(currentPosition) + ", ");
				this.invoke(numberAsString, currentPosition + 1);
			}
		};
		
		action.invoke(Integer.toString(Math.abs(number)), 0);
	}
}
