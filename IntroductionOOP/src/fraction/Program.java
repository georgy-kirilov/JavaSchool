package edu.school;

public class Program 
{
	public static void main(String[] args)
	{
		// initialization
		Fraction a = new Fraction(10, 18);
		Fraction b = new Fraction(23, 69);
		
		// addition
		System.out.println(a + " + " + b + " = " + a.add(b));
		
		// subtraction
		System.out.println(a + " - " + b + " = " + a.subtract(b));
		
		// multiplication
		System.out.println(a + " * " + b + " = " + a.multiply(b));
		
		// division
		System.out.println(a + " / " + b + " = " + a.divide(b));
		
		// simplification
		System.out.print(a + " = ");
		a.simplify();
		System.out.print(a);
	}
}
