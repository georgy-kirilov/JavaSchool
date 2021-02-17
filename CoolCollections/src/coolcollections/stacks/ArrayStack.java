package coolcollections.stacks;

import java.util.Iterator;

import common.Helper;

public class ArrayStack<T> implements Stack<T>
{
	public static final int INITIAL_CAPACITY = 4;
	
	private T[] array;
	private int count;
	
	@SuppressWarnings("unchecked")
	public ArrayStack()
	{
		this.array = (T[]) new Object[INITIAL_CAPACITY];
		this.count = 0;
	}
	
	@Override
	public void push(T item)
	{	
		if (this.count >= this.array.length)
		{
			this.expand();
		}
		
		this.array[this.count] = item;
		this.count++;
	}

	@Override
	public T pop()
	{
		this.throwIfStackIsEmpty();
		T item = this.array[this.count - 1];
		this.count--;
		return item;
	}

	@Override
	public T peek()
	{
		this.throwIfStackIsEmpty();
		return this.array[this.count - 1];
	}

	@Override
	public int search(T item)
	{
		for (int i = 0; i < this.count; i++)
		{
			if (Helper.areEqual(this.array[i], item))
			{
				return i;
			}
		}
		
		return -1;
	}

	@Override
	public boolean empty()
	{
		return this.count <= 0;
	}
	
	@Override
	public Iterator<T> iterator()
	{
		return new Iterator<T>()
		{
			private int index = count - 1;
			
			@Override
			public boolean hasNext()
			{
				return this.index >= 0 && this.index < count;
			}

			@Override
			public T next()
			{
				T item = array[this.index];
				this.index--;
				return item;
			}
		};
	}
	
	@SuppressWarnings("unchecked")
	private void expand()
	{
		int length = this.array.length * 2;
		T[] copy = (T[]) new Object[length];
		
		for (int i = 0; i < this.array.length; i++)
		{
			copy[i] = this.array[i];
		}
		
		this.array = copy;
	}
	
	private void throwIfStackIsEmpty()
	{
		if (this.empty())
		{
			throw new RuntimeException("Stack was empty");
		}
	}
}
