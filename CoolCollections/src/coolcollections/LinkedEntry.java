package coolcollections;

class LinkedEntry<K, V> extends Entry<K, V>
{
	private LinkedEntry<K, V> next;
	private LinkedEntry<K, V> previous;
	
	public LinkedEntry(K key, V value)
	{
		super(key, value);
		this.setNext(null);
		this.setPrevious(null);
	}
	
	public LinkedEntry<K, V> getNext()
	{
		return this.next;
	}
	
	public LinkedEntry<K, V> getPrevious()
	{
		return this.previous;
	}
	
	public void setNext(LinkedEntry<K, V> next)
	{
		this.next = next;
	}
	
	public void setPrevious(LinkedEntry<K, V> previous)
	{
		this.previous = previous;
	}
}
