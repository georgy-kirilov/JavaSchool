package exams.feb_22;

public class P03
{
	public static void main(String[] args)
	{
		int[] arr = new int[] { 1, 2, 3, 4, 5, 6, 7, 1, 2, 4, 3 };
		printUniqueItems(arr, 0);
	}
	
	static void printUniqueItems(int[] arr, int startIndex)
	{
		if (startIndex == arr.length)
		{
			return;
		}
		if (solve(arr, startIndex, 0))
		{
			System.out.print(arr[startIndex] + ", ");
		}
		printUniqueItems(arr, startIndex + 1);
	}
	
	static boolean solve(int[] arr, int start, int current)
	{
		if (current == arr.length)
		{
			return true;
		}
		
		if (start != current && arr[start] == arr[current])
		{
			return false;
		}
		
		return solve(arr, start, current + 1);
	}
}
