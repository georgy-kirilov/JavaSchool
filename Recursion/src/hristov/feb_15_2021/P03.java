package hristov.feb_15_2021;

import functions.Func;

public class P03
{
	public static void main(String[] args)
	{
		int[] array = { 0, 10, -9, 90, 16, -18, 87, -1, 1, 22, 4 };
		boolean findMax = false;
		int result = findElement(array, findMax);
		System.out.println(result);
	}
	
	static int findElement(int[] array, boolean findMax)
	{
		Func<Integer, Integer, Integer> func = new Func<Integer, Integer, Integer>()
		{
			@Override
			public Integer invoke(Integer result, Integer index)
			{
				if (index >= array.length)
				{
					return result;
				}
				
				if (findMax && result < array[index] || !findMax && result > array[index])
				{
					result = array[index];
				}
				
				return this.invoke(result, index + 1);
			}
		};
		
		return func.invoke(array[0], 0);
	}
}
