package solutions;
import java.util.Scanner;
import java.util.Random;

public class P03_Lottery 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		Random random = new Random();
		int min = 5, max = 36; 
		int[] winningNumbers = new int[5];
		int[] guessNumbers = new int[winningNumbers.length];
		
		for (int i = 0; i < winningNumbers.length; i++)
		{
			int number = 0;
			
			while (true)
			{
				boolean numberAlreadyExists = false;
				number = random.nextInt(max - min) + min;
				
				for (int k = 0; k < i; k++)
				{
					if (winningNumbers[k] == number)
					{
						numberAlreadyExists = true;
						break;
					}
				}
				
				if (!numberAlreadyExists)
					break;
			}
			
			winningNumbers[i] = number;
			
			while (true)
			{
				System.out.print("Enter guess: ");
				number = scan.nextInt();
				
				boolean numberInRange = number >= 5 && number <= 35;
				boolean numberAlreadyExists = false;
				
				for (int k = 0; k < i; k++)
				{
					if (guessNumbers[k] == number)
					{
						numberAlreadyExists = true;
						break;
					}
				}
				
				if (numberAlreadyExists)
				{
					System.out.println("You have already chosen this number. Choose another");
				}
				
				if (!numberInRange)
				{
					System.out.println("The input is not in range");
				}
				
				if (!numberAlreadyExists && numberInRange)
					break;
			}
			
			guessNumbers[i] = number;
		}
		
		System.out.print("Winning combination: ");
		
		for (int number : winningNumbers)
		{
			System.out.print(number + " ");
		}
		
		System.out.print("\nYour combination: ");
		
		for (int number : guessNumbers)
		{
			System.out.print(number + " ");
		}
		
		String output = "";
		
		for (int i = 0; i < winningNumbers.length; i++)
		{
			int currentWinner = winningNumbers[i];
			
			for (int k = 0; k < guessNumbers.length; k++)
			{
				if (currentWinner == guessNumbers[k])
				{
					output += currentWinner + " ";
				}
			}
		}
		
		output = output == "" ? "none" : output;
		System.out.print("\nGuessed numbers: " + output);
		scan.close();
	}
}
