package datastructures.lists;

import java.util.Iterator;

import datastructures.CommonHelper;
import datastructures.Node;

public class SortedLinkedList<T extends Comparable<T>> implements SortedList<T>
{
	private Node<T> first;
	private int count;
	private boolean ascendingOrder;
	
	public SortedLinkedList()
	{
		this(true);
	}
	
	public SortedLinkedList(boolean ascendingOrder)
	{
		this.clear();
		this.ascendingOrder = ascendingOrder;
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
				T value = current.value;
				current = current.next;
				return value;
			}
		};
	}

	@Override
	public void add(T item)
	{	
		if (this.size() == 0)
		{
			this.first = new Node<T>(item);
		}
		else
		{
			Node<T> current = this.first, previous = this.first;
			
			while (current != null)
			{
				boolean insertionPossible = current.value != null && 
						(this.ascendingOrder && current.value.compareTo(item) > 0 || 
						!this.ascendingOrder && current.value.compareTo(item) < 0);
				
				if (insertionPossible)
				{
					if (current == this.first)
					{
						this.first = new Node<T>(item, previous);
					}
					
					break;
				}
				
				previous = current;
				current = current.next;
			}
			
			previous.next = new Node<T>(item, current);
		}
		
		this.count++;
	}

	@Override
	public boolean remove(T item)
	{
		Node<T> current = this.first, previous = this.first;
		
		while (current != null)
		{
			if (CommonHelper.areEqual(current.value, item))
			{
				if (current == this.first)
				{
					this.first = this.first.next;
				}
				else
				{
					previous.next = current.next;					
				}
				
				return true;
			}
			
			previous = current;
			current = current.next;
		}
		
		return false;
	}

	@Override
	public T removeAt(int index) {
		return null;
		
	}

	@Override
	public boolean contains(T item) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int indexOf(T item) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void clear()
	{
		this.first = null;
		this.count = 0;
	}

	@Override
	public int size()
	{
		return this.count;
	}
	
	@Override
	public String toString()
	{
		StringBuilder listBuilder = new StringBuilder();
		for (T item : this)
		{
			listBuilder.append(item);
			listBuilder.append(" ");
		}
		return listBuilder.toString().trim();
	}
}
