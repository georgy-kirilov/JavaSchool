package solutions;
import java.util.Random;

public class P04_CoinToss 
{
	public static void main(String[] args) 
	{
		Random random = new Random();
		boolean isHeads = random.nextBoolean();		
		String coinSide = isHeads ? "Heads" : "Tails";
		System.out.println(coinSide);
	}
}
