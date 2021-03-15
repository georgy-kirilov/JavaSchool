package lists;

import java.util.LinkedList;
import java.util.List;

public class P04
{
	public static void main(String[] args)
	{
		int n = 64;
		List<Integer> list = createList(n);
		
		for (int div = 2; div < Math.sqrt(n); div++)
		{
			if (isPrime(div))
			{
				final int s = div;
				list.removeIf(x -> x != s && x % s == 0);
			}
		}
		
		P03.printList(list);
	}
	
	public static List<Integer> createList(int size)
	{
		LinkedList<Integer> list = new LinkedList<>();
		for (int n = 2; n <= size; n++)
		{
			list.add(n);
		}
		
		return list;
	}
	
	public static boolean isPrime(int number)
	{
		if (number == 0 || number == 1)
		{
			return false;
		}
		
		for (int div = 2; div < Math.sqrt(number); div++)
		{
			if (number % div == 0)
			{
				return false;
			}
		}
		
		return true;
	}
}
