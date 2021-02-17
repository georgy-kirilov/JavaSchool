package coolcollections.lists;

public interface List<T> extends Iterable<T>
{	
	int count();
	
	void add(T item);
	
	void addAll(Iterable<T> collection);
	
	void insert(int index, T item);
	
	T get(int index);
	
	void set(int index, T item);
	
	boolean remove(T item);
	
	T removeAt(int index);
	
	int indexOf(T item);
	
	boolean contains(T item);
	
	boolean containsAll(Iterable<T> collection);

	void clear();
	
	List<T> subList(int startIndex, int endIndex);
}
