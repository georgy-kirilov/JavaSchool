package funcs;

public interface BigFunc<Ta, Tb, Tout>
{
	Tout invoke(Ta a, Tb b);
}