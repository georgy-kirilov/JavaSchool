package datastructures;

public class Test
{
	public static void main(String[] args)
	{
		LinkedList<Integer> list = new LinkedList<>();
		
		list.add(10);
		list.add(100);
		list.add(9);
		list.add(0);
		list.remove(9);
		
		for (int a : list)
		{
			System.out.println(a);
		}
		
		/*List<String> l = new LinkedList<>();
		l.add(null);
		l.insertAt(0, "pesho");
		System.out.println(l.contains("pesho"));*/
	}
}
