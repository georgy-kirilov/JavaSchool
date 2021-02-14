package denev.feb_17_2021;

import actions.Action;

public class P03_P04
{
	public static void main(String[] args)
	{
		int[] tests = { 561326, -1910, 20488, -9, 10 };
		
		for (int test : tests)
		{
			System.out.println("Normal: " + test);
			System.out.print("Left: " + printDigits(test, true));
			System.out.print("Right: " + printDigits(test, false));
			System.out.println();
		}
	}
	
	static String printDigits(int number, boolean fromLeft)
	{	
		StringBuilder sb = new StringBuilder();
		
		Action<String, Integer> action = new Action<String, Integer>()
		{
			@Override
			public void invoke(String numberAsString, Integer position)
			{
				if (position >= numberAsString.length() || position < 0)
				{
					sb.append("\n");
					return;
				}
				
				int offset = fromLeft ? 1 : -1;
				sb.append(numberAsString.charAt(position) + ", ");
				this.invoke(numberAsString, position + offset);
			}
		};

		String numberAsString = Integer.toString(Math.abs(number));
		int position = fromLeft ? 0 : numberAsString.length() - 1;
		action.invoke(numberAsString, position);
		
		return sb.toString();
	}
}
