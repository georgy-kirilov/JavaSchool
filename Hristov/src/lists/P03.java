package lists;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class P03
{
	public static void main(String[] args)
	{
		try (Scanner in = new Scanner(System.in))
		{
			int n = in.nextInt();
			
			LinkedList<Integer> numbers = new LinkedList<>();
			
			for (int i = 0; i < n; i++)
			{
				numbers.addLast(in.nextInt());
			}
			
			for (int i = 0; i < n; i++)
			{
				printList(numbers);
				int first = numbers.removeFirst();
				numbers.addLast(first);
			}
		}
	}
	
	public static <T> void printList(List<T> list)
	{
		for (T item : list)
		{
			System.out.printf("%s ", item);
		}
		
		System.out.println();
	}
}
