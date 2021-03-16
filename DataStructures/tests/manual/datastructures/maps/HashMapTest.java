package manual.datastructures.maps;

import datastructures.maps.Entry;
import datastructures.maps.HashMap;
import datastructures.maps.Map;

public class HashMapTest
{
	public static void main(String[] args)
	{
		HashMap<String, Integer> map = new HashMap<>();
		map.put("John", 20);
		map.put("Steven", 33);
		map.put("Simon", 18);
		map.put("Mike", 54);
		map.put("Alex", 47);
		map.put("Kim", 27);
		map.put("Henry", 39);
		map.put("Bob", 8);

		System.out.println("Map size -> " + map.size());
		printMap(map);

		map.remove("Bob");
		map.remove("John");
		map.remove("Mike");
		map.remove(null);

		printMap(map);

		map.put("Henry", 69);
		map.put("Steven", 96);

		printMap(map);

		System.out.println("Bob's age -> " + map.get("Bob"));
		System.out.println("Kim's age -> " + map.get("Kim"));

		System.out.println("Contains key 'Alex' -> " + map.containsKey("Alex"));
		System.out.println("Contains key 'Bob' -> " + map.containsKey("Bob"));

		map.put(null, 888);
		System.out.println("Is map empty -> " + map.isEmpty());

		System.out.println("Null value -> " + map.get(null));
		System.out.println("Contains key null -> " + map.containsKey(null));

		System.out.println("Map size -> " + map.size());
		printMap(map);

		map.clear();
		printMap(map);

		System.out.println("Is map empty -> " + map.isEmpty());
	}

	public static <K, V> void printMap(Map<K, V> map)
	{
		StringBuilder mapBuilder = new StringBuilder();

		for (Entry<K, V> entry : map)
		{
			mapBuilder.append(entry.getKey() + ", " + entry.getValue() + " | ");
		}

		String result = mapBuilder.length() == 0 ? "Map is empty" : mapBuilder.toString();
		System.out.println(result);
	}
}
