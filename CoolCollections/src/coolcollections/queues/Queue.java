package coolcollections.queues;

public interface Queue<T> extends Iterable<T>
{
	int count();
	
	void enqueue(T item);
	
	void enqueueAll(Iterable<T> collection);
	
	T dequeue();
	
	T peek();
	
	void clear();
	
	boolean empty();
}
