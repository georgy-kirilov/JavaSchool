package coolcollections.stacks;

public interface Stack<T> extends Iterable<T>
{
	int count();
	
	void push(T item);
	
	T pop();
	
	T peek();
	
	int search(T item);
	
	boolean empty();
}
