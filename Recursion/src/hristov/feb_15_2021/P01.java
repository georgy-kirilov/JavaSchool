package hristov.feb_15_2021;

import delegates.Func;

public class P01
{
	public static void main(String[] args)
	{
		int[] first = {1, 2, 3, 2, 5};
		int[] second = { 0, 5, 9 };
		
		boolean equalElements = checkForEqualElements(first, second);
		System.out.println(equalElements);
		
		int count = elementCountInArray(first, 2);
		System.out.println(count);
	}
	
	static boolean checkForEqualElements(int[] first, int[] second)
	{	
		Func<Integer, Integer, Boolean> func = new Func<Integer, Integer, Boolean>()
		{
			@Override
			public Boolean invoke(Integer firstIndex, Integer secondIndex)
			{
				if (secondIndex >= second.length)
				{
					secondIndex = 0;
					firstIndex++;
				}
					
				if (firstIndex >= first.length)
				{
					return false;
				}
				
				if (first[firstIndex] == second[secondIndex])
				{
					return true;
				}
				
				return this.invoke(firstIndex, secondIndex + 1);
			}
		};
		
		return func.invoke(0, 0);
	}
	
	static int elementCountInArray(int[] array, int element)
	{
		Func<Integer, Integer, Integer> func = new Func<Integer, Integer, Integer>()
		{
			@Override
			public Integer invoke(Integer count, Integer index)
			{
				if (index == array.length)
				{
					return count;
				}
				
				if (array[index] == element)
				{
					count++;
				}
				
				return this.invoke(count, index + 1);
			}
		};
		
		return func.invoke(0, 0);
	}
}
