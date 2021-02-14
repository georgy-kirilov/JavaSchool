package denev.feb_14_2021;

public class P06
{
	public static void main(String[] args)
	{
		int[] array = { -9, -5, 0, 1, 5, 6, 8, 16, 80, 91, 100, 231, 699 };
		System.out.println(binarySearch(array, 80, array.length / 2, -1));
	}
	
	static int binarySearch(int[] array, int elementToFind, int middle, int prev)
	{
		System.out.println(middle);
		if (elementToFind == array[middle])
		{
			return middle;
		}
		else if (elementToFind < array[middle])
		{
			return binarySearch(array, elementToFind, middle / 2, middle);	
		}
		
		return 0;//binarySearch(array, elementToFind, (int)(middle + middle / 2));
	}
}
