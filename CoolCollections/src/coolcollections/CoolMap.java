package coolcollections;

public interface CoolMap<K, V>
{
	void add(K key, V value);
	
	Entry<K, V> get(K key);

	void set(K key, V value);
	
	boolean containsKey(K key);
}
