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
		printStack(stack);
		
		ArrayStack<Integer> otherStack = new ArrayStack<>();
		otherStack.push(40);
		otherStack.push(50);
		
		stack.pushAll(otherStack);
		printStack(stack);
		
		stack.clear();
		printStack(stack);
	}
	
	static <T> void printStack(Stack<T> stack)
	{
		String result = "[";
		
		for (T item : stack)
		{
			result += item + " ";
		}
		
		System.out.println(result.trim() + "]");
	}
}
