package coolcollections.stacks;

public interface Stack<T> extends Iterable<T>
{
	void push(T item);
	
	T pop();
	
	T peek();
	
	int search(T item);
	
	boolean empty();
}
