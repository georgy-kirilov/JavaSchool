package solutions;
import java.util.Scanner;

public class P06_Array 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		int size = scan.nextInt();
		int[] numbers = new int[size];
		
		for (int i = 0; i < numbers.length; i++)
		{
			numbers[i] = scan.nextInt();
		}
		
		for (int i = 0; i < numbers.length - 1; i++)
		{
			if (numbers[i] >= 0)
			{
				String line = "";
				
				for (int k = i + 1; k < numbers.length; k++)
				{
					if (numbers[i] == numbers[k])
					{
						line += k + " ";
						numbers[k] = -1;
					}
				}
				
				if (line.length() > 0)
				{
					line = i + " " + line;
					System.out.println(line);
				}
			}
		}
		
		scan.close();
	}
}
