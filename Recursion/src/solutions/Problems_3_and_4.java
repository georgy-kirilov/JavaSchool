package solutions;

import actions.Action;

public class Problems_3_and_4
{
	public static void main(String[] args)
	{
		int[] tests = new int[] { 561326, -1910, 20488, -9, 10 };
		
		for (int test : tests)
		{
			System.out.println("Normal: " + test);
			System.out.print("Left: ");
			printDigits(test, true);
			System.out.print("Right: ");
			printDigits(test, false);
			System.out.println();
		}
	}
	
	static void printDigits(int number, boolean fromLeft)
	{	
		Action<String, Integer> action = new Action<String, Integer>()
		{
			@Override
			public void invoke(String numberAsString, Integer position)
			{
				if (position >= numberAsString.length() || position < 0)
				{
					System.out.println();
					return;
				}
				
				int offset = fromLeft ? 1 : -1;
				
				System.out.print(numberAsString.charAt(position) + ", ");
				this.invoke(numberAsString, position + offset);
			}
		};

		String numberAsString = Integer.toString(Math.abs(number));
		int position = fromLeft ? 0 : numberAsString.length() - 1;
		action.invoke(numberAsString, position);
	}
}
