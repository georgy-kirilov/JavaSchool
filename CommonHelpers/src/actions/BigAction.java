package actions;

public interface BigAction<Ta, Tb, Tc>
{
	void invoke(Ta a, Tb b, Tc c);
}
