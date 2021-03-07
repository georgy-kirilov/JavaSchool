package solutions;
import java.util.Scanner;

public class P03_SmallestDistanceBetweenTwoPoints 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter points count: ");
		int pointsCount = scan.nextInt();
		
		int[] elements = new int[2 * pointsCount];
		
		for (int i = 0; i < elements.length; i++)
		{
			elements[i] = scan.nextInt();
		}
		
		int firstPointIndex = 0, secondPointIndex = 2;
		double minDistance = 0;
		
		for (int i = 0; i < elements.length; i += 2)
		{
			int x1 = elements[i], y1 = elements[i + 1];
			
			for (int k = 0; k < elements.length; k += 2)
			{
				int x2 = elements[k], y2 = elements[k + 1];
				double distance = Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2);
				distance = Math.sqrt(distance);
				
				if (i == 0 && k == 0)
				{
					minDistance = distance;
				}
				else if (minDistance > distance)
				{
					minDistance = distance;
					firstPointIndex = i;
					secondPointIndex = k;
				}
			}
		}
		
		System.out.println(elements[firstPointIndex] + "; " + elements[firstPointIndex + 1]);
		System.out.println(elements[secondPointIndex] + "; " + elements[secondPointIndex + 1]);
		
		scan.close();
	}
}
