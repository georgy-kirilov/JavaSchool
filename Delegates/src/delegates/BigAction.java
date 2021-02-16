package delegates;

public interface BigAction<T, U, V>
{
	void invoke(T first, U second, V third);
}
