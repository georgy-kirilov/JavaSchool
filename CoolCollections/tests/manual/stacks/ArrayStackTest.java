package manual.stacks;

import coolcollections.stacks.ArrayStack;
import coolcollections.stacks.Stack;

public class ArrayStackTest
{
	public static void main(String[] args)
	{
		Stack<Integer> stack = new ArrayStack<>();
		
		for (int i = 1; i <= 10; i++)
		{
			stack.push(i);
		}
		
		System.out.println("Stack count: " + stack.count());
		System.out.println("Index of 7: " + stack.search(7));
		System.out.println("Current item on top: " + stack.peek());
		
		String result = "";
		
		while (!stack.empty())
		{
			result += stack.pop() + " ";
		}
		
		System.out.println(result);
		
		stack.push(10);
		stack.push(20);
		stack.push(30);
		
		for (int item : stack)
		{
			System.out.println(item);
		}
	}
}
