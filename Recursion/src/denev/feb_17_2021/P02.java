package denev.feb_17_2021;

import functions.TinyFunc;

public class P02
{
	public static void main(String[] args)
	{
		int[] tests = { -2455, 988, 100, 12121, 0 };
		
		for (int test : tests)
		{
			int sum = sumOfDigits(test);
			System.out.printf("%d -> %d\n", test, sum);
		}
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
