package datastructures.lists;

import java.util.Arrays;
import java.util.Iterator;

import datastructures.CommonHelper;
import datastructures.Node;

public class LinkedList<T> implements List<T>
{	
	private Node<T> first;
	private Node<T> last;
	private int count;
	
	public LinkedList()
	{
		this.clear();
	}
	
	public LinkedList(Iterable<T> iterable)
	{
		this();
		for (T item : iterable)
		{
			this.add(item);
		}
	}
	
	public LinkedList(T[] array)
	{
		this(Arrays.asList(array));
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

	/** O(1) complexity */
	@Override
	public void add(T item)
	{
		if (this.first == null)
		{
			this.first = new Node<T>(item);
		}
		else if (this.last == null)
		{
			this.last = new Node<T>(item);
			this.first.next = last;
		}
		else
		{
			Node<T> oldLast = this.last;
			this.last = new Node<T>(item);			
			oldLast.next = last;
		}
		
		this.count++;
	}

	/** O(n) complexity */
	@Override
	public void insert(int index, T item)
	{
		CommonHelper.throwIfIndexOutOfRange(index, this.count);
		
		if (index == 0)
		{
			this.first = new Node<T>(item, this.first);
		}
		else
		{
			Node<T> current = this.first;
			int currentIndex = 0;
			
			while (current != null)
			{
				if (currentIndex == index - 1)
				{
					current.next = new Node<T>(item, current.next);
					break;
				}
				
				currentIndex++;
				current = current.next;
			}
		}
		
		this.count++;
	}

	/** O(n) complexity */
	@Override
	public T removeAt(int index)
	{
		CommonHelper.throwIfIndexOutOfRange(index, this.count);
		T removed = this.first.value;
		
		if (index == 0)
		{
			this.first = this.first.next;
		}
		else
		{
			Node<T> current = this.first;
			int currentIndex = 0;
			
			while (current != null)
			{
				if (currentIndex == index - 1)
				{
					removed = current.next.value;
					current.next = current.next.next;
					break;
				}
				
				currentIndex++;
				current = current.next;
			}
		}
		
		this.count--;
		return removed;
	}

	/** O(n) complexity */
	@Override
	public boolean remove(T item)
	{
		Node<T> current = this.first;
		Node<T> previous = current;
		int currentIndex = 0;
		
		while (current != null)
		{
			if (CommonHelper.areEqual(current.value, item))
			{
				if (currentIndex == 0)
				{
					this.first = current.next;
				}
				else
				{
					previous.next = current.next;	
				}
				
				this.count--;
				return true;
			}
			
			previous = current;
			current = current.next;
			currentIndex++;
		}
		
		return false;
	}

	/** O(n) complexity */
	@Override
	public T get(int index)
	{
		int currentIndex = 0;
		
		for (T item : this)
		{
			if (currentIndex == index)
			{
				return item;
			}
			
			currentIndex++;
		}
		
		throw new IllegalArgumentException(CommonHelper.INDEX_OUT_OF_RANGE);
	}

	@Override
	public int indexOf(T item)
	{
		int index = 0;
		for (T current : this)
		{
			if (CommonHelper.areEqual(current, item))
			{
				return index;
			}
			index++;
		}
		return -1;
	}
	
	/** O(n) complexity */
	@Override
	public void set(int index, T item)
	{
		CommonHelper.throwIfIndexOutOfRange(index, this.count);
		
		int currentIndex = 0;
		Node<T> current = this.first;
		
		while (current != null)
		{
			if (currentIndex == index)
			{
				current.value = item;
				break;
			}
			
			current = current.next;
			currentIndex++;
		}
	}
	
	/** O(1) complexity */
	@Override
	public void clear()
	{
		this.first = null;
		this.last = null;
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
			private Node<T> current = first;
			
			@Override
			public boolean hasNext()
			{
				return current != null;
			}

			@Override
			public T next()
			{
				Node<T> old = current;
				this.current = this.current.next;
				return old.value;
			}
		};
	}
}
