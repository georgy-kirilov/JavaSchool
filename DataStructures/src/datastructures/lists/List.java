package datastructures.lists;

public interface List<T> extends Iterable<T>
{
	boolean isEmpty();
	boolean contains(T item);
	void add(T item);
	void insert(int index, T item);
	T removeAt(int index);
	boolean remove(T item);
	int indexOf(T item);
	T get(int index);
	void set(int index, T item);
	void clear();
	int size();
}
