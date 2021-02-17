package coolcollections.lists;

import java.util.Iterator;

import common.Helper;

public class ArrayList<T> implements List<T>
{
	public static final int INITIAL_CAPACITY = 4;
	
	private T[] array;
	private int count;
	
	public ArrayList(Iterable<T> collection)
	{
		this();
		this.addAll(collection);
	}
	
	public ArrayList()
	{
		this(INITIAL_CAPACITY);
	}
	
	public ArrayList(int initialCapacity)
	{
		this.clear();
	}
	
	@Override
	public int count()
	{
		return this.count;
	}

	@Override
	public void add(T item)
	{
		if (this.count() >= this.capacity())
		{
			this.expand();
		}
		
		this.array[this.count()] = item;
		this.count++;
	}

	@Override
	public void addAll(Iterable<T> collection)
	{
		for (T item : collection)
		{
			this.add(item);
		}
	}
	
	@Override
	public void insert(int index, T item)
	{
		this.throwIfOutOfRange(index);
		
		if (this.count() >= this.capacity())
		{
			this.expand();
		}
		
		for (int i = this.count(); i > index; i--)
		{
			this.array[i] = this.array[i - 1];
		}
		
		this.set(index, item);
		this.count++;
	}
	
	@Override
	public T get(int index)
	{
		this.throwIfOutOfRange(index);
		return this.array[index];
	}
	
	@Override
	public void set(int index, T item)
	{
		this.throwIfOutOfRange(index);
		this.array[index] = item;
	}
	
	@Override
	public boolean remove(T item)
	{
		for (int i = 0; i < this.count(); i++)
		{
			if (Helper.areEqual(this.array[i], item))
			{
				this.removeAt(i);
				return true;
			}
		}
		
		return false;
	}

	@Override
	public T removeAt(int index)
	{
		T removedItem = this.get(index);
		
		for (int i = index; i < this.count - 1; i++)
		{
			this.array[i] = this.array[i + 1];
		}
		
		this.count--;
		return removedItem;
	}
	
	@Override
	public int indexOf(T item)
	{
		for (int i = 0; i < this.count(); i++)
		{
			if (Helper.areEqual(this.array[i], item))
			{
				return i;
			}
		}
		
		return -1;
	}
	
	@Override
	public boolean contains(T item)
	{
		return this.indexOf(item) >= 0;
	}
	
	@Override
	public boolean containsAll(Iterable<T> collection)
	{
		boolean allExist = false;
		
		for (T current : collection)
		{
			allExist = false;
			
			for (T next : this)
			{
				if (Helper.areEqual(current, next))
				{
					allExist = true;
					break;
				}
			}
		}
		
		return allExist;
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
				return index < count();
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
	
	@Override
	@SuppressWarnings("unchecked")
	public void clear()
	{
		this.array = (T[]) new Object[INITIAL_CAPACITY];
		this.count = 0;
	}
	
	@Override
	public List<T> subList(int startIndex, int endIndex)
	{
		ArrayList<T> subList = new ArrayList<T>();
		
		for (int i = startIndex; i <= endIndex; i++)
		{
			subList.add(this.get(i));
		}
		
		return subList;
	}
	
	public int capacity()
	{
		return this.array.length;
	}
	
	@SuppressWarnings("unchecked")
	private void expand()
	{
		int length = this.capacity() * 2;
		T[] copy = (T[]) new Object[length];
		
		for (int i = 0; i < this.capacity(); i++)
		{
			copy[i] = this.array[i];
		}
		
		this.array = copy;
	}
	
	private void throwIfOutOfRange(int index)
	{
		if (index < 0 || index >= this.count())
		{
			throw new IllegalArgumentException("Index was outside the list bounds");
		}
	}
}
