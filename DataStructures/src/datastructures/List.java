package datastructures;
public interface List<T>
{
	boolean isEmpty();
	boolean contains(T item);
	void add(T item);
	void insert(int index, T item);
	void removeAt(int index);
	void remove(T item);
	T get(int index);
	void set(int index, T item);
	void clear();
	int size();
}
