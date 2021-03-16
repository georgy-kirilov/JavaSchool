package datastructures.maps;

import java.util.Iterator;

import datastructures.CommonHelper;

public class HashMap<K, V> implements Map<K, V>
{
	private HashMapNode[] nodes;
	private int size;
	
	public HashMap()
	{
		this.clear();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void clear()
	{
		this.nodes = new HashMap.HashMapNode[5];
		this.size = 0;
	}

	@Override
	public boolean containsKey(K key)
	{
		int index = this.calculateIndex(key, this.nodes.length);
		HashMapNode current = this.nodes[index];
		
		while (current != null)
		{
			if (CommonHelper.areEqual(current.entry.getKey(), key))
			{
				return true;
			}
			
			current = current.next;
		}
		
		return false;
	}

	@Override
	public V get(K key)
	{
		int index = this.calculateIndex(key, this.nodes.length);
		HashMapNode current = this.nodes[index];

		while (current != null)
		{
			if (CommonHelper.areEqual(current.entry.getKey(), key))
			{
				return current.entry.getValue();
			}
			
			current = current.next;
		}
		
		return null;
	}

	@Override
	public V put(K key, V value)
	{
		int index = this.calculateIndex(key, this.nodes.length);
		HashMapNode current = this.nodes[index];
		HashMapNode newNode = new HashMapNode(key, value);
		
		if (current == null)
		{
			this.nodes[index] = newNode;
		}
		else
		{
			while (current != null)
			{
				if (CommonHelper.areEqual(current.entry.getKey(), key))
				{
					current.entry.setValue(value);
					return value;
				}
				
				if (current.next == null)
				{
					current.next = newNode;
					break;
				}
				
				current = current.next;
			}
		}
		
		this.size++;
		
		if ((double)this.size / this.nodes.length > 0.8)
		{
			this.expand();
		}
		
		return value;
	}

	@Override
	public int size()
	{
		return this.size;
	}

	@Override
	public V remove(K key)
	{
		int index = this.calculateIndex(key, this.nodes.length);
		HashMapNode current = this.nodes[index];
		HashMapNode previous = current;

		while (current != null)
		{
			if (CommonHelper.areEqual(current.entry.getKey(), key))
			{
				if (previous == current)
				{
					this.nodes[index] = current.next;
				}
				else
				{
					previous.next = current.next;
				}

				this.size--;
				return current.entry.getValue();
			}
			
			previous = current;
			current = current.next;
		}
		
		return null;
	}

	@Override
	public boolean isEmpty()
	{
		return this.size <= 0;
	}

	@Override
	public Iterator<Entry<K, V>> iterator()
	{
		return new Iterator<Entry<K, V>>()
		{
			private int arrayIndex = 0;
			private boolean insideChain = false;
			private HashMapNode current = nodes[arrayIndex];
			
			@Override
			public boolean hasNext()
			{
				for (int i = this.arrayIndex; i < nodes.length; i++)
				{
					if (!this.insideChain)
					{
						this.current = nodes[i];						
						this.insideChain = true;
					}
					
					while (this.current != null)
					{
						return true;
					}
					
					this.arrayIndex++;
					this.insideChain = false;
				}
				
				return false;
			}
			
			@Override
			public Entry<K, V> next()
			{
				Entry<K, V> next = this.current.entry;
				this.current = this.current.next;
				return next;
			}
		};
	}
	
	private int calculateIndex(K key, int length)
	{
		return key == null ? 0 : Math.abs(key.hashCode()) % length;
	}
	
	@SuppressWarnings("unchecked")
	private void expand()
	{
		HashMapNode[] copy = new HashMap.HashMapNode[this.nodes.length * 2];
		
		for (Entry<K, V> entry : this)
		{
			int index = this.calculateIndex(entry.getKey(), copy.length);
			HashMapNode current = copy[index];
			HashMapNode newNode = new HashMapNode(entry.getKey(), entry.getValue());
			
			if (current == null)
			{
				copy[index] = newNode;
				continue;
			}
			
			while (current != null)
			{
				if (CommonHelper.areEqual(current.entry.getKey(), entry.getKey()))
				{
					current.entry.setValue(entry.getValue());
				}
				
				if (current.next == null)
				{
					current.next = newNode;
					break;
				}
				
				current = current.next;
			}
		}
		
		this.nodes = copy;
	}
	
	private class HashMapNode
	{
		public Entry<K, V> entry;
		public HashMapNode next;
		
		public HashMapNode(K key, V value)
		{
			this.entry = new Entry<>(key, value);
		}
	}
}
