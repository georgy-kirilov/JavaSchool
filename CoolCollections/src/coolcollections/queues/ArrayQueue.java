package coolcollections.queues;

import java.util.Iterator;

public class ArrayQueue<T> implements Queue<T>
{
	@Override
	public Iterator<T> iterator() {
		throw new UnsupportedOperationException();
	}

	@Override
	public int count() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void enqueue(T item) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void enqueueAll(Iterable<T> collection) {
		throw new UnsupportedOperationException();
	}

	@Override
	public T dequeue() {
		throw new UnsupportedOperationException();
	}

	@Override
	public T peek() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void clear() {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean empty() {
		throw new UnsupportedOperationException();
	}
}
