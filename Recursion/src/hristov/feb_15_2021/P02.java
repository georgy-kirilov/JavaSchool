package hristov.feb_15_2021;

import actions.TinyAction;

public class P02
{
	public static void main(String[] args)
	{
		printNumbers(15);
		
		System.out.println();
		
		printNumbers(-5);
	}
	
	static void printNumbers(int lastNumber)
	{
		int offset = lastNumber >= 0 ? 1 : -1;
		
		TinyAction<Integer> action = new TinyAction<Integer>()
		{
			@Override
			public void invoke(Integer current)
			{
				if (current > lastNumber && offset > 0 || current < lastNumber && offset < 0)
				{
					return;
				}
				
				String info = "";
				
				if (current % 3 == 0)
				{
					info += "Fizz";
				}
				
				if (current % 5 == 0)
				{
					info += "Buzz";
				}
				
				System.out.println(current + " " + info);
				current += offset;
				
				this.invoke(current);
			}
		};
		
		action.invoke(0);
	}
}
