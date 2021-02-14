package functions;

public interface Func<T, U, Tout>
{
	Tout invoke(T first, U second);
}
