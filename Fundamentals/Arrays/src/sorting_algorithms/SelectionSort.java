package sorting_algorithms;
import java.util.Scanner;

public class SelectionSort 
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
		
		for (int i = 0; i < array.length - 1; i++)
		{
			int maxIndex = i;
			
			for (int k = i + 1; k < array.length; k++)
			{
				if (array[maxIndex] > array[k])
				{
					maxIndex = k;
				}
			}
			
			int temp = array[i];
			array[i] = array[maxIndex];
			array[maxIndex] = temp;
		}
		
		for (int item : array)
		{
			System.out.print(item + " ");
		}
		
		scan.close();
	}
}
