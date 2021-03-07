package solutions;

public class P01_FibonacciArray 
{
	public static void main(String[] args) 
	{
		int count = 20;
		int[] fibonacciNumbers = new int[count];
		int current = 0, next = 1;
		
		for (int i = 0; i < fibonacciNumbers.length; i++)
		{
			fibonacciNumbers[i] = current;
			int temp = next;
			next += current;
			current = temp;
		}
		
		for (int i = 0; i < fibonacciNumbers.length; i++)
		{
			String output = "[" + (i + 1) + "] = " + fibonacciNumbers[i];
			System.out.println(output);
		}
	}
}
