package exams.feb_22;

public class P04
{
	public static void main(String[] args)
	{
		int[] first = new int[] { 1, 2, 3, 4, 5, 6 };
		int[] second = new int[] { 1, 4, 16, 24, 37 };
		printItems(first, second, 0, 0);
	}
	
	static void printItems(int[] first, int[] second, int firstIndex, int secondIndex)
	{
		if (firstIndex >= first.length)
		{
			return;
		}
		
		if (secondIndex >= second.length)
		{
			firstIndex++;
			secondIndex = 0;
		}
		else if (first[firstIndex] * first[firstIndex] == second[secondIndex])
		{
			System.out.print(first[firstIndex] + ", ");
			firstIndex++;
			secondIndex = 0;
		}
		else
		{
			secondIndex++;
		}
		
		printItems(first, second, firstIndex, secondIndex);
	}
}
