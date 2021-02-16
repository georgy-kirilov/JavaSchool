package hristov.sorting;

import java.util.Arrays;

import delegates.Action;

public class RecursiveSelectionSort
{
	public static void main(String[] args)
	{
		Integer[] array = { 3, -9, 0, 12, 7 };
		System.out.println(Arrays.toString(array));
		
		selectionSort(array, true);
		System.out.println(Arrays.toString(array));
		
		selectionSort(array, false);
		System.out.println(Arrays.toString(array));
	}
	
	static void selectionSort(Integer[] array, boolean ascending)
	{
		Action<Integer, Integer> action = new Action<Integer, Integer>()
		{
			@Override
			public void invoke(Integer currentIndex, Integer nextIndex)
			{
				if (nextIndex >= array.length)
				{
					currentIndex++;
					nextIndex = currentIndex;
				}

				if (currentIndex >= array.length)
				{
					return;
				}
				
				boolean shouldSwap = ascending && array[currentIndex] > array[nextIndex]
						|| !ascending && array[currentIndex] < array[nextIndex];
				
				if (shouldSwap)
				{
					int temp = array[currentIndex];
					array[currentIndex] = array[nextIndex];
					array[nextIndex] = temp;
				}
				
				this.invoke(currentIndex, nextIndex + 1);
			}
		};
		
		action.invoke(0, 0);
	}
}
