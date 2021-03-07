package datastructures.lists;

public class Test
{
	public static void main(String[] args)
    {
        List<Integer> list = new LinkedList<>();

        for (int i = 0; i < 10; i++)
        {
            list.add(i);
        }

        printList(list);
        System.out.println("List count: " + list.size());

        list.insert(8, 999);
        printList(list);

        list.remove(5);
        printList(list);

        list.removeAt(0);
        printList(list);

        System.out.println("[4] = " + list.get(4));

        list.set(4, 888);
        printList(list);

        System.out.println("Contains 888: " + list.contains(888));
        System.out.println("Contains 788: " + list.contains(788));
        System.out.println("Index of 8: " + list.indexOf(8));

        ArrayList<Integer> otherList = new ArrayList<>();

        otherList.add(2);
        otherList.add(888);
        otherList.add(999);
    }

    static <T> void printList(List<T> list)
    {
        String result = "[";
        for (T item : list)
        {
            result += item + " ";
        }
        System.out.println(result.trim() + "]");
    }
}
