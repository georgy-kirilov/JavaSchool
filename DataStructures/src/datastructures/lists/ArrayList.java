package datastructures.lists;

import java.util.Arrays;
import java.util.Iterator;

import datastructures.CommonHelper;

public class ArrayList<T> implements List<T>
{
	private static final int INITIAL_CAPACITY = 4;
	
	private T[] array;
	private int count;
	
	public ArrayList(T[] array)
	{
		this(Arrays.asList(array));
	}
	
	public ArrayList(Iterable<T> iterable)
	{
		this();
		for (T item : iterable)
		{
			this.add(item);
		}
	}
	
	public ArrayList()
	{
		this(INITIAL_CAPACITY);
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList(int initialCapacity)
	{
		this.array = (T[]) new Object[initialCapacity];
		this.count = 0;
	}
	
	/** O(1) complexity */
	@Override
	public boolean isEmpty()
	{
		return this.count == 0;
	}

	/** O(n) complexity */
	@Override
	public boolean contains(T item)
	{
		return this.indexOf(item) != -1;
	}

	/** O(log n) complexity */
	@Override
	public void add(T item)
	{
		if (this.count >= this.array.length)
        {
            this.expand();
        }
        this.array[this.count] = item;
        this.count++;
	}

	/** O(n) complexity */
	@Override
	public void insert(int index, T item)
	{
		CommonHelper.throwIfIndexOutOfRange(index, this.count);
        if (this.count >= this.array.length)
        {
            this.expand();
        }
        for (int i = this.count; i > index; i--)
        {
            this.array[i] = this.array[i - 1];
        }
        this.set(index, item);
        this.count++;
	}

	/** O(n) complexity */
	@Override
	public T removeAt(int index)
	{	
		T removed = this.get(index);
        for (int i = index; i < this.count - 1; i++)
        {
            this.array[i] = this.array[i + 1];
        }
        this.count--;
        return removed;
	}

	/** O(n) complexity */
	@Override
	public boolean remove(T item)
	{
		int index = this.indexOf(item);
        if (index >= 0)
        {
            this.removeAt(index);
            return true;
        }
        return false;
	}

	/** O(n) complexity */
	@Override
    public int indexOf(T item)
    {
        for (int i = 0; i < this.count; i++)
        {
            if (CommonHelper.areEqual(this.array[i], item))
            {
                return i;
            }
        }
        return -1;
    }
	
	/** O(1) complexity */
	@Override
	public T get(int index)
	{
		CommonHelper.throwIfIndexOutOfRange(index, this.count);
        return this.array[index];
	}

	/** O(1) complexity */
	@Override
	public void set(int index, T item)
	{
		CommonHelper.throwIfIndexOutOfRange(index, this.count);
        this.array[index] = item;
	}

	/** O(1) complexity */
	@SuppressWarnings("unchecked")
	@Override
	public void clear()
	{
		this.array = (T[]) new Object[INITIAL_CAPACITY];
		this.count = 0;
	}

	/** O(1) complexity */
	@Override
	public int size()
	{
		return this.count;
	}

	@Override
	public Iterator<T> iterator()
	{
		return new Iterator<T>()
		{
			private int index = 0;
			
			@Override
			public boolean hasNext()
			{
				return this.index < count;
			}

			@Override
			public T next()
			{
				T next = array[index];
				index++;
				return next;
			}
		};
	}
	
	@SuppressWarnings("unchecked")
    private void expand()
    {
        T[] copy = (T[]) new Object[this.array.length * 2];
        for (int i = 0; i < this.array.length; i++)
        {
            copy[i] = this.array[i];
        }
        this.array = copy;
    }
}
