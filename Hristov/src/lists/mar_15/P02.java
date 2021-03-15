package lists.mar_15;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class P02
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		String[] numbersAsString = in.nextLine().split(" ", -1);
		LinkedList<Integer> numbers = new LinkedList<>();
		
		for (String numberAsString : numbersAsString)
		{
			numbers.add(Integer.parseInt(numberAsString));
		}
		
		Collections.sort(numbers);
		int max = numbers.removeLast();
		
		while (numbers.size() > 0)
		{
			System.out.println(Math.pow(numbers.removeFirst() + max, 2));
		}
		
		in.close();
	}
}
