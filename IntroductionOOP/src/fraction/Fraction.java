package edu.school;

public class Fraction 
{
	private int nominator;
	private int denominator;
	
	public Fraction(int nominator, int denominator)
	{
		this.setNominator(nominator);
		this.setDenominator(denominator);
	}
	
	public Fraction()
	{
		this(0, 1);
	}
	
	public Fraction(int nominator)
	{
		this(nominator, 1);
	}
	
	public int getNominator()
	{
		return this.nominator;
	}
	
	public int getDenominator()
	{
		return this.denominator;
	}
	
	public void setNominator(int value)
	{
		this.nominator = value;
	}
	
	public void setDenominator(int value)
	{
		this.denominator = value;
		
		if (value == 0)
			this.denominator = 1;
	}
	
	public String toString()
	{
		String output = String.valueOf(this.nominator);
		output += this.denominator == 1 ? "" : "/" + this.denominator;
		return output;
	}
	
	public Fraction multiply(Fraction f)
	{
		int nominator = this.getNominator() * f.getNominator();
		int denominator = this.getDenominator() * f.getDenominator();
		
		Fraction product = new Fraction(nominator, denominator);
		return simplify(product);
	}
	
	public Fraction divide(Fraction f)
	{
		Fraction invertedFraction = new Fraction(f.getDenominator(), f.getNominator());
		return this.multiply(invertedFraction);
	}
	
	public Fraction subtract(Fraction f)
	{	
		int scm = smallestCommonMultiple(this.getDenominator(), f.getDenominator());
		int nominator = findNewNominator(scm, this) - findNewNominator(scm, f);
		
		Fraction difference = new Fraction(nominator, scm);
		return simplify(difference);
	}
	
	public Fraction add(Fraction f)
	{	
		int scm = smallestCommonMultiple(this.getDenominator(), f.getDenominator());
		int nominator = findNewNominator(scm, this) + findNewNominator(scm, f);
		
		Fraction sum = new Fraction(nominator, scm);
		return simplify(sum);
	}
	
	public void simplify()
	{
		Fraction f = simplify(this);
		this.setNominator(f.getNominator());
		this.setDenominator(f.getDenominator());
	}
	
	public static Fraction simplify(Fraction f)
	{
		int gcd = greatestCommonDivisor(f.getNominator(), f.getDenominator());
		
		int newNominator = f.getNominator() / gcd;
		int newDenominator = f.getDenominator() / gcd;
		
		return new Fraction(newNominator, newDenominator);
	}
	
	public static int smallestCommonMultiple(int a, int b)
	{
		int div = 2, scm = 1;
		
		while (a != 1 || b != 1)
		{
			boolean isDivisible = false;
			
			if (a % div == 0)
			{
				isDivisible = true;
				a /= div;
			}
			
			if (b % div == 0)
			{
				isDivisible = true;
				b /= div;
			}
			
			if (!isDivisible)
				div++;
			else
				scm *= div;
		}
		
		return scm;
	}
	
	public static int greatestCommonDivisor(int a, int b)
	{
		int min = Math.min(Math.abs(a), Math.abs(b));
		
		for (int div = min; div >= 2; div--)
		{
			if (a % div == 0 && b % div == 0)
				return div;
		}
		
		return 1;
	}
	
	private static int findNewNominator(int scm, Fraction f)
	{
		int nominator = scm / f.getDenominator() * f.getNominator();
		return nominator;
	}
}
