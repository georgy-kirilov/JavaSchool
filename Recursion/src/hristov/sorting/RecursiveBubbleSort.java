package hristov.sorting;

import java.util.Arrays;

import delegates.BigAction;

public class RecursiveBubbleSort
{
	public static void main(String[] args)
	{
		int[] array = { 9, 8, 2, 0, 1, -13, 50, 5, 9 };
		bubbleSort(array, true);
		System.out.println(Arrays.toString(array));
	}
	
	static void bubbleSort(int[] array, boolean ascending)
	{	
		BigAction<Integer, Integer, Boolean> action = new BigAction<Integer, Integer, Boolean>()
		{
			@Override
			public void invoke(Integer currentIndex, Integer endIndex, Boolean sorted)
			{
				if (currentIndex >= endIndex)	
				{
					if (sorted)
					{
						return;
					}
					
					currentIndex = 0;
					endIndex--;
					sorted = true;
				}
				
				boolean shouldSwap = ascending && array[currentIndex] > array[currentIndex + 1]
						|| !ascending && array[currentIndex] < array[currentIndex + 1];
				
				if (shouldSwap)
				{
					int temp = array[currentIndex];
					array[currentIndex] = array[currentIndex + 1];
					array[currentIndex + 1] = temp;
					sorted = false;
				}
				
				this.invoke(currentIndex + 1, endIndex, sorted);
			}
		};
		
		action.invoke(0, array.length - 1, true);
	}
}
