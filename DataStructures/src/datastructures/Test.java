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
		
		for (int a : list)
		{
			System.out.println(a);
		}
	}
}
