package datastructures.maps;

public interface Map<K, V> extends Iterable<Entry<K, V>>
{
	void clear();
	boolean containsKey(K key);
	V get(K key);
	V put(K key, V value);
	int size();
	V remove(K key);
	boolean isEmpty();
}
