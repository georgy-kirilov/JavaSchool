package solutions;
import java.util.Scanner;
import java.util.Random;

public class P05_RockPaperScissors 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		Random random = new Random();
		String[] options = new String[] { "Rock", "Paper", "Scissors" };
		
		int computerIndex = random.nextInt(options.length);
		
		System.out.println("Rock - 0\nPaper - 1\nScissors - 2");
		int playerIndex = scan.nextInt();
		
		while (computerIndex == playerIndex)
		{
			computerIndex = random.nextInt(options.length);
			System.out.println("Draw. Choose again");
			System.out.println("Rock - 0\nPaper - 1\nScissors - 2");
			playerIndex = scan.nextInt();
		}
		
		boolean humanHasWon = playerIndex == 0 && computerIndex == 2 || 
						playerIndex == 1 && computerIndex == 0 ||
						playerIndex == 2 && computerIndex == 1;
		
		if (humanHasWon)
		{
			System.out.println("You won!");
		}
		else
		{
			System.out.println("You lost.");
		}
		
		System.out.println("You: " + options[playerIndex]);
		System.out.println("Computer: " + options[computerIndex]);
		
		scan.close();
	}
}
