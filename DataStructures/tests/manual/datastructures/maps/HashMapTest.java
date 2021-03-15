package manual.datastructures.maps;

import datastructures.maps.Entry;
import datastructures.maps.HashMap;
//import java.util.*;
public class HashMapTest
{
	public static void main(String[] args)
	{
		HashMap<String, Integer> map = new HashMap<>();
		map.put(null, 0);
		map.put("Ivan", 1);
		map.put("Joe", 90);
		System.out.println(map.containsKey(null));
		System.out.println(map.get(null));
		System.out.println(map.remove("Joe"));
		/*for (Entry<String, Integer> entry : map)
		{
			System.out.println(entry.getKey());
		}*/
	}
}
