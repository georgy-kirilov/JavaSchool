package lists.mar_15;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class P03
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		Stack<Integer> stack = new Stack<>();
		String line = in.nextLine();
		
		for (int i = 0; i < line.length(); i++)
		{
			char current = line.charAt(i);
			if (Character.isDigit(current))
			{
				stack.push(current - '0');
			}
		}
		
		long number = 0;
		int multiplier = (int)Math.pow(10, stack.size() - 1);
		
		while (!stack.isEmpty())
		{
			number += multiplier * stack.pop();
			multiplier /= 10;
		}
		System.out.println(number);
		
		LinkedList<Byte> binary = new LinkedList<>();
		
		while (number != 0)
		{
			binary.addFirst((byte)(number % 2));
			number /= 2;
		}
		
		System.out.println(join(binary));
		in.close();
	}
	
	public static <T> String join(List<T> list)
	{
		StringBuilder sb = new StringBuilder();
		
		for (T item : list)
		{
			sb.append(item);
		}
		
		return sb.toString();
	}
}
