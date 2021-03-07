package sorting_algorithms;
import java.util.Scanner;

public class BubbleSort 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		int size = scan.nextInt();
		
		int[] array = new int[size];
		
		for (int i = 0; i < array.length; i++)
		{
			array[i] = scan.nextInt();
		}
		
		boolean swapped = true;
		
		while (swapped)
		{
			swapped = false;
			
			for (int i = 0; i < array.length - 1; i++)
			{
				if (array[i] > array[i + 1])
				{
					int temp = array[i];
					array[i] = array[i + 1];
					array[i + 1] = temp;
					swapped = true;
				}
			}
		}
		
		for (int item : array)
		{
			System.out.print(item + " ");
		}
		
		scan.close();
	}
}
