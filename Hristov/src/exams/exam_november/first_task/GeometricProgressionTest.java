package exams.exam_november.first_task;

public class GeometricProgressionTest 
{
	private static final String NEW_LINE = "\n";
	
	public static void main(String[] args)
	{
		GeometricProgression progression = new GeometricProgression();
		System.out.println("Default constructor:");
		System.out.println(progression + NEW_LINE);
		
		System.out.println("Common use constructor:");
		progression = new GeometricProgression(2, 2);
		System.out.println(progression + NEW_LINE);
		
		System.out.println("calculateNthTerm:");
		System.out.println(progression.calculateNthTerm(5) + NEW_LINE);
		System.out.println("sumOfNTerms:");
		System.out.println(progression.sumOfNTerms(10) + NEW_LINE);
		
		System.out.println("printNTermsStartingFromM:");
		System.out.println(progression.printNTermsStartingFromM(3, 5));
	}
}
