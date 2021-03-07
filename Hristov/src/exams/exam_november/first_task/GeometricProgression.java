package exams.exam_november.first_task;

public class GeometricProgression 
{
	private static final String CANNOT_BE_ZERO = "%s cannot be equal to zero";
	private static final String LESS_THAN_OR_EQUAL_TO_ZERO = "%s cannot be less than or equal to zero";
	
	private static final double DEFAULT_INITIAL_TERM = 1;
	private static final double DEFAULT_COMMON_RATIO = 2;
	
	private double initialTerm;
	private double commonRatio;
	
	public GeometricProgression()
	{
		this(DEFAULT_INITIAL_TERM, DEFAULT_COMMON_RATIO);
	}
	
	public GeometricProgression(double initialTerm, double commonRatio)
	{
		this.setInitialTerm(initialTerm);
		this.setCommonRatio(commonRatio);
	}
	
	
	public double getInitialTerm()
	{
		return this.initialTerm;
	}
	
	public void setInitialTerm(double value)
	{
		if (value == 0)
		{
			String message = String.format(CANNOT_BE_ZERO, "Initial Term");
			throw new RuntimeException(message);
		}
		
		this.initialTerm = value;
	}
	
	public double getCommonRatio()
	{
		return this.commonRatio;
	}
	
	public void setCommonRatio(double value)
	{
		if (value == 0)
		{
			String message = String.format(CANNOT_BE_ZERO, "Common Ratio");
			throw new RuntimeException(message);
		}
			
		this.commonRatio = value;
	}
	
	public String toString()
	{
		String format = "[a1 = %s, q = %s]";
		String geometricProgressionInfo = String.format
				(format, this.getInitialTerm(), this.getCommonRatio());
		
		return geometricProgressionInfo;
	}
	
	public double calculateNthTerm(int n)
	{	
		if (n <= 0)
		{
			String message = String.format(LESS_THAN_OR_EQUAL_TO_ZERO, "N");
			throw new RuntimeException(message);
		}
		
		double term = this.getInitialTerm() * 
					Math.pow(this.getCommonRatio(), n - 1);
		
		return term;
	}
	
	public double sumOfNTerms(int n)
	{	
		if (n <= 0)
		{
			String message = String.format(LESS_THAN_OR_EQUAL_TO_ZERO, "N");
			throw new RuntimeException(message);
		}
		
		double sum = 0;
		
		for (int i = 1; i <= n; i++)
		{
			sum += this.calculateNthTerm(i);
		}
		
		return sum;
	}
	
	// Changed method return type in order to achieve better code reusability
	
	public String printNTermsStartingFromM(int m, int n)
	{	
		StringBuilder output = new StringBuilder();
		String format = "a%s = %s\n";
		
		for (int i = m; i <= m + n; i++)
		{
			double currentTerm = this.calculateNthTerm(i);
			output.append(String.format(format, i, currentTerm));
		}
		
		return output.toString().trim();
	}
}
