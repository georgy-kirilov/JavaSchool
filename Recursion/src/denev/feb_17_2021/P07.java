package denev.feb_17_2021;

import delegates.Func;

public class P07
{
	public static void main(String[] args)
	{
		int gcd = greatestCommonDivisor(12, 8);
		System.out.println(gcd);
		
		gcd = greatestCommonDivisor(80, 8);
		System.out.println(gcd);
		
		gcd = greatestCommonDivisor(7, 7);
		System.out.println(gcd);
		
		gcd = greatestCommonDivisor(-18, 3);
		System.out.println(gcd);
		
		gcd = greatestCommonDivisor(44, -12);
		System.out.println(gcd);
	}
	
	static int greatestCommonDivisor(int a, int b)
	{
		Func<Integer, Integer, Integer> func = new Func<Integer, Integer, Integer>()
		{
			@Override
			public Integer invoke(Integer a, Integer b)
			{
				int min = Math.min(a, b);
				
				if (a % min == 0 && b % min == 0)
				{
					return min;
				}
				
				return this.invoke(b, a % b);
			}
		};
		
		return func.invoke(Math.abs(a), Math.abs(b));
	}
}
