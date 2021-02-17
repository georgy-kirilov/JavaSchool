package coolcollections;

import java.util.Iterator;

public abstract class CoolHashMap<TKey, TValue> extends QueryableCollection<Entry<TKey, TValue>> implements CoolMap<TKey, TValue>
{
	/*public static final int INITIAL_CAPACITY = 100;
	
	private LinkedEntry<TKey, TValue>[] entries;
	private int count;
	
	@SuppressWarnings("unchecked")
	public CoolHashMap()
	{
		this.entries = (LinkedEntry<TKey, TValue>[]) new Object[INITIAL_CAPACITY];
		this.count = 0;
	}

	@Override
	public void add(TKey key, TValue value)
	{
		this.throwIfKeyIsNull(key);
		
		int keyIndex = Math.abs(key.hashCode() % this.count());
		LinkedEntry<TKey, TValue> entry = this.entries[keyIndex];
		LinkedEntry<TKey, TValue> newEntry = new LinkedEntry<>(key, value);
		
		if (entry == null)
		{
			this.entries[keyIndex] = newEntry;
		}
		else
		{
			while (true)
			{
				if (entry.getKey().equals(key))
				{
					throw new IllegalArgumentException("Item with such key already exists");
				}
				
				if (entry.getNext() == null)
				{
					newEntry.setPrevious(entry);
					entry.setNext(newEntry);
					break;
				}
				
				entry = entry.getNext();
			}
		}
		
		this.count++;
	}

	@Override
	public Entry<TKey, TValue> get(TKey key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void set(TKey key, TValue value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean containsKey(TKey key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<Entry<TKey, TValue>> iterator()
	{
		return new Iterator<Entry<TKey, TValue>>()
		{
			private int index = 0;
			
			@Override
			public boolean hasNext()
			{
				while (index < count())
				{
					if (entries[index] != null)
					
					index++;
				}
				
				return false;
			}

			@Override
			public Entry<TKey, TValue> next() {
				// TODO Auto-generated method stub
				return null;
			}
		};
	}
	
	@Override
	public int count()
	{
		return this.count;
	}
	
	private void throwIfKeyIsNull(TKey key)
	{
		if (key == null)
		{
			throw new IllegalArgumentException("Key cannot be null");
		}
	}*/
}
