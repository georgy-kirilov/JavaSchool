package coolcollections.stacks;

public interface Stack<T> extends Iterable<T>
{
	int count();
	
	void push(T item);
	
	void pushAll(Iterable<T> collection);
	
	T pop();
	
	T peek();
	
	int search(T item);
	
	boolean empty();
	
	void clear();
}
