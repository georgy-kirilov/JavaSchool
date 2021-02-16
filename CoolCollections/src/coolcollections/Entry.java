package coolcollections;

public class Entry<K, V>
{
	private K key;
	private V value;
	
	public Entry(K key, V value)
	{
		this.setKey(key);
		this.setValue(value);
	}
	
	public K getKey()
	{
		return this.key;
	}
	
	public V getValue()
	{
		return this.value;
	}
	
	public void setKey(K key)
	{
		this.key = key;
	}
	
	public void setValue(V value)
	{
		this.value = value;
	}
}
