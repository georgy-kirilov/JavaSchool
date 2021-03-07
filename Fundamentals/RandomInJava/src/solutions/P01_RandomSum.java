package solutions;
import java.util.Random;

public class P01_RandomSum 
{
	public static void main(String[] args) 
	{
		int min = 1, max = 7;
		Random random = new Random();
		int a = random.nextInt(max - min) + min;
		int b = random.nextInt(max - min) + min;
		System.out.println(a + " + " + b + " = " + (a + b));
	}
}
