package solutions;

public class Problem_1
{
	public static void main(String[] args)
	{
		int sum = sumOfElements(5);
		System.out.println(sum);
	}
	
	static int sumOfElements(int last)
	{
		Func<Integer, Integer, Integer> func = new Func<Integer, Integer, Integer>()
		{
			@Override
			public Integer invoke(Integer current, Integer last)
			{
				if (current == last)
				{
					return last;
				}
				
				return current + this.invoke(current + 1, last);
			}
		};
		
		return func.invoke(0, last);
	}
}
