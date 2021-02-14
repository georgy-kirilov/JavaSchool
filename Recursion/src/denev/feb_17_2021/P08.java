package denev.feb_17_2021;

import functions.Func;

public class P08 
{
	public static void main(String[] args)
	{
		int[] array = { 8, 16, 24, 32 };
		int gcd = greatestCommonDivisor(array);
		System.out.println(gcd);
	}
	
	static int greatestCommonDivisor(int[] array)
	{	
		Func<Integer, Integer, Integer> func = new Func<Integer, Integer, Integer>()
		{
			@Override
			public Integer invoke(Integer gcd, Integer index)
			{
				gcd = P07.greatestCommonDivisor(gcd, array[index]);
				
				if (index == array.length - 1)
				{
					return gcd;
				}
				
				return this.invoke(gcd, index + 1);
			}
		};
		
		return func.invoke(array[0], 0);
	}
}
