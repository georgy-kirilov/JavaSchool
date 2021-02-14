package solutions;

import funcs.TinyFunc;

public class Problem_2
{
	public static void main(String[] args)
	{
		int digitSum = sumOfDigits(-2455);
		System.out.println(digitSum);
		
		digitSum = sumOfDigits(1020);
		System.out.println(digitSum);
	}
	
	static int sumOfDigits(int number)
	{
		TinyFunc<Integer, Integer> func = new TinyFunc<Integer, Integer>()
		{
			@Override
			public Integer invoke(Integer number)
			{
				if (number <= 0)
				{
					return 0;
				}
				
				int digit = number % 10;
				return digit + this.invoke(number / 10);
			}
		};
		
		return func.invoke(Math.abs(number));
	}
}
