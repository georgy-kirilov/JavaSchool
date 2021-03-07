package solutions;
import java.util.Scanner;
import java.util.Random;

public class P02_GuessTheNumber 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		Random random = new Random();
		int min = 10, max = 51, userGuess;
		int numberToBeGuessed = random.nextInt(max - min) + min;
		boolean hasGuessed = false;
		
		for (int i = 0; i < 5; i++)
		{
			System.out.print("Enter your guess: ");
			userGuess = scan.nextInt();
			
			if (userGuess > numberToBeGuessed)
			{
				System.out.println("Your guess was bigger");
			}
			else if (userGuess < numberToBeGuessed)
			{
				System.out.println("Your guess was smaller");
			}
			else
			{
				hasGuessed = true;
				break;
			}
		}
		
		if (hasGuessed)
		{
			System.out.println("Congrats. You've guessed it!");
		}
		else
		{
			System.out.println("Sorry, you couldn't guess it. It was " + numberToBeGuessed);
		}
	
		scan.close();
	}
}
