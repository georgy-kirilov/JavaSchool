package actions;

public interface Action<Ta, Tb>
{
	void invoke(Ta a, Tb b);
}
