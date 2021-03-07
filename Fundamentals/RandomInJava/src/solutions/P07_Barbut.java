package solutions;
import java.util.Random;
import java.util.Arrays;

public class P07_Barbut 
{
	public static void main(String[] args) 
	{
		int diceCount = 3, minDiceValue = 1, maxDiceValue = 6;
		int[] dice = new int[diceCount];
		Random random = new Random();
		int onesCount = 0, fivesCount = 0;
		
		System.out.print("Combination: ");
		
		for (int i = 0; i < dice.length; i++)
		{
			dice[i] = random.nextInt(maxDiceValue) + minDiceValue;
			
			System.out.print(dice[i] + " ");
			
			if (dice[i] == 1)
			{
				onesCount++;
			}
			else if (dice[i] == 5)
			{
				fivesCount++;
			}
		}
		
		Arrays.sort(dice);
		
		int points = onesCount * 100 + fivesCount * 50;

		boolean hasConsecutiveNumbers = dice[0] == 1 && dice[1] == 2 && dice[2] == 3 ||
										dice[0] == 2 && dice[1] == 3 && dice[2] == 4 ||
										dice[0] == 3 && dice[1] == 4 && dice[2] == 5 ||
										dice[0] == 4 && dice[1] == 5 && dice[2] == 6 ||
										dice[0] == 1 && dice[1] == 3 && dice[2] == 5 ||
										dice[0] == 2 && dice[1] == 4 && dice[2] == 6;
		
		boolean areAllNumbersEqual = dice[0] == dice[1] && dice[1] == dice[2];
		
		if (areAllNumbersEqual)
		{
			if (dice[0] == 1)
			{
				points += 1000;
			}
			else if (dice[0] >= 2 && dice[0] <= 5)
			{
				points += dice[0] * 100;
			}
			else
			{
				points = 0;
			}
		}
		else if (hasConsecutiveNumbers)
		{
			points += 200;
		}
		
		System.out.print("\nPoints: " + points);
	}
}
