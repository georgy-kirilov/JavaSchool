package lists;



import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
public class CoolArrayListTest
{
	public static void main(String[] args)
	{
		Stack<String> stack = new Stack<>();
		List<Integer> list = new ArrayList<Integer>();
		list.add
		System.out.println(list.toString());
		/*List<String> names = new ArrayList<String>();
		
		names.add("Ivan");
		names.add("Petar");
		names.add("Stefan");
		names.add("Alex");
		names.add("John Doe");
		names.add("Bobi");
		
		List<String> newNames = names.where(n -> n.charAt(0) <= 'K').toList();
		
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
		System.out.println(newNames.join(null));
		
		boolean nameWithXExists = newNames.any(x -> x != null && x.contains("s"));
		System.out.println(nameWithXExists);
		
		System.out.println(newNames.all(x -> x == null));
		newNames.remove(null);
		
		System.out.println(newNames.all(x -> x.length() > 3));
		System.out.println(newNames.firstOrDefault(x -> x.length() > 10));
		
		List<Integer> numbers = new ArrayList<Integer>();
		numbers.add(7);
		numbers.add(2);
		numbers.add(0);
		numbers.add(6);
		numbers.add(8);
		numbers.add(9);
		numbers.add(-70);
		
		System.out.println(numbers.firstOrDefault(x -> x > 90));
		numbers.each(n -> System.out.printf("%d -> %d\n", n, n * n));
		
		System.out.println(numbers.sortByDescending(n -> n).join(", "));*/
	}
}
