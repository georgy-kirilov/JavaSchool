package lists;

import coolcollections.CoolList;
import coolcollections.CoolArrayList;

public class CoolArrayListTest
{
	public static void main(String[] args)
	{
		CoolList<String> names = new CoolArrayList<String>();
		
		names.add("Ivan");
		names.add("Petar");
		names.add("Stefan");
		names.add("Alex");
		names.add("John Doe");
		names.add("Bobi");
		
		CoolList<String> newNames = names.where(n -> n.charAt(0) <= 'K').toList();
		
		for (String name : newNames)
		{
			System.out.println(name);
		}
		
		newNames.remove("Bobi");
		newNames.insert(0, "New Bobi");
		
		for (String name : newNames)
		{
			System.err.println(name);
		}
		
		newNames.add(null);
		
		System.out.println(newNames.contains("John Doe"));
		System.out.println(newNames.contains(null));
		System.out.println(newNames.contains("Shrek"));
	}
}
