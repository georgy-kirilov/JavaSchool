package datastructures.maps;

public class Entry<K, V>
{
	private K key;
	private V value;
	
	public Entry(K key, V value)
	{
		this.key = key;
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
	
	public void setValue(V value)
	{
		this.value = value;
	}
}
