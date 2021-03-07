package solutions;

public class P08_SwapArray 
{
	public static void main(String[] args) 
	{
		int[] array = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 };
		
		for (int i = 0; i < array.length / 2; i++)
		{
			int temp = array[i], index = array.length - 1 - i;
			array[i] = array[index];
			array[index] = temp;
		}
		
		for (int i = 0; i < array.length; i++)
		{
			System.out.print(array[i] + " ");
		}
	}
}
