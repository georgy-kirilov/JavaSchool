package coolcollections;

public interface CoolList<T> extends Queryable<T>
{
	int count();
	
	T get(int index);
	
	void set(int index, T item);
	
	void add(T item);
	
	boolean remove(T item);
	
	void insert(int index, T item);
	
	boolean contains(T item);
	
	int capacity();
	
	void clear();
}
