package denev.feb_17_2021;

import delegates.BigAction;

public class P05
{
	public static void main(String[] args)
	{	
		int sequenceLength = 5;
		
		for (int base = 1; base <= 10; base++)
		{
			printSequence(sequenceLength, base);
			System.out.println();
		}
	}
	
	static void printSequence(int sequenceLength, int base)
	{
		BigAction<Integer, Long, Boolean> action = new BigAction<Integer, Long, Boolean>()
		{
			@Override
			public void invoke(Integer power, Long currentNumber, Boolean increasing)
			{
				if (!increasing && power == 0)
				{
					System.out.println();
					return;
				}
				
				System.out.print(currentNumber + ", ");
				
				power = increasing ? power + 1 : power - 1;
				currentNumber = increasing ? currentNumber * base : currentNumber / base;
				
				if (power > sequenceLength && increasing)
				{
					increasing = false;
					currentNumber /= base;
					power--;
				}
				
				this.invoke(power, currentNumber, increasing);
			}
		};
		
		action.invoke(1, 1L, true);
	}
}
