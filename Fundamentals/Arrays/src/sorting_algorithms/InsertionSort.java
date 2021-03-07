package sorting_algorithms;
import java.util.Scanner;

public class InsertionSort 
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
		
		for (int i = 1; i < array.length; i++)
		{
			int k = i;
				
			while (k > 0 && array[k - 1] > array[k])
			{	
				int temp = array[k];
				array[k] = array[k - 1];
				array[k - 1] = temp;
				k--;
			}
		}
		
		for (int item : array)
		{
			System.out.print(item + " ");
		}
		
		scan.close();
	}
}
