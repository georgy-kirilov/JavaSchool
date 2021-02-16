package delegates;

public interface Func<T, U, Out>
{
	Out invoke(T first, U second);
}
