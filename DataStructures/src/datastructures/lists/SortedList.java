package datastructures.lists;

public interface SortedList<T extends Comparable<T>> extends Iterable<T>
{
	void add(T item);
	boolean remove(T item);
	T removeAt(int index);
	boolean contains(T item);
	int indexOf(T item);
	void clear();
	int size();
}
