package solutions;

public interface Func<Ta, Tb, Tout>
{
	Tout invoke(Ta a, Tb b);
}
