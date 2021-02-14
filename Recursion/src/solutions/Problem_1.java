package solutions;

import funcs.BigFunc;

public class Problem_1
{
	public static void main(String[] args)
	{
		int sum = sumOfElements(10);
		System.out.println(sum);
	}
	
	static int sumOfElements(int last)
	{
		BigFunc<Integer, Integer, Integer> func = new BigFunc<Integer, Integer, Integer>()
		{
			@Override
			public Integer invoke(Integer current, Integer last)
			{
				if (current == last)
				{
					return last;
				}
				
				return current + this.invoke(current + 1, last);
			}
		};
		
		return func.invoke(0, last);
	}
}
