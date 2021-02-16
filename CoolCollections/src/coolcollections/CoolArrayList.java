package coolcollections;

import java.util.Iterator;

public class CoolArrayList<T> extends QueryableCollection<T> implements CoolList<T>
{
	public static final int INITIAL_CAPACITY = 4;
	
	private T[] items;
	private int count;
	
	public CoolArrayList()
	{
		this(INITIAL_CAPACITY);
	}
	
	@SuppressWarnings("unchecked")
	public CoolArrayList(int initialCapacity)
	{
		this.items = (T[]) new Object[initialCapacity];
		this.count = 0;
	}
	
	public CoolArrayList(Iterable<T> iterable)
	{
		this.clear();
		
		for (T item : iterable)
		{
			this.add(item);
		}
	}

	@Override
	public void add(T item)
	{
		if (this.count() >= this.capacity())
		{
			this.expand();
		}
		
		this.items[this.count()] = item;
		this.count++;
	}

	@Override
	public boolean remove(T item)
	{
		for (int i = 0; i < this.count(); i++)
		{
			if (this.checkIfEqual(this.items[i], item))
			{
				this.removeAt(i);
				this.count--;
				return true;
			}
		}
		
		return false;
	}

	@Override
	public void removeAt(int index)
	{
		this.moveItemsToTheLeft(index);
		this.count--;
	}
	
	@Override
	public void insert(int index, T item)
	{
		this.moveItemsToTheRight(index);
		this.set(index, item);
	}

	@Override
	public int count()
	{
		return this.count;
	}

	@Override
	public T get(int index)
	{
		this.throwIfOutOfRange(index);
		return this.items[index];
	}
	
	@Override
	public void set(int index, T item)
	{
		this.throwIfOutOfRange(index);
		this.items[index] = item;
	}

	@Override
	public boolean contains(T item)
	{
		for (T current : this)
		{
			if (this.checkIfEqual(current, item))
			{
				return true;
			}
		}
		
		return false;
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
				if (index < count())
				{
					return true;
				}
				
				index = 0;
				return false;
			}

			@Override
			public T next()
			{
				T next = items[index];
				index++;
				return next;
			}
		};
	}

	@Override
	public int capacity()
	{
		return this.items.length;
	}

	@Override
	@SuppressWarnings("unchecked")
	public void clear()
	{
		this.items = (T[]) new Object[INITIAL_CAPACITY];
		this.count = 0;
	}
	
	@SuppressWarnings("unchecked")
	private void expand()
	{
		int length = this.capacity() * 2;
		T[] copy = (T[]) new Object[length];
		
		for (int i = 0; i < this.capacity(); i++)
		{
			copy[i] = this.items[i];
		}
		
		this.items = copy;
	}
	
	private void throwIfOutOfRange(int index)
	{
		if (index < 0 || index >= this.count())
		{
			throw new IllegalArgumentException("Index was outside the list bounds");
		}
	}
	
	private void moveItemsToTheLeft(int index)
	{
		this.throwIfOutOfRange(index);
		
		for (int i = index; i < this.count - 1; i++)
		{
			this.items[i] = this.items[i + 1];
		}
	}
	
	private void moveItemsToTheRight(int index)
	{
		this.throwIfOutOfRange(index);
		
		if (this.count() >= this.capacity())
		{
			this.expand();
		}
		
		for (int i = this.count(); i > index; i--)
		{
			this.items[i] = this.items[i - 1];
		}
	}
	
	private boolean checkIfEqual(T first, T second)
	{
		return first == null && second == null || first != null && first.equals(second);
	}
}
