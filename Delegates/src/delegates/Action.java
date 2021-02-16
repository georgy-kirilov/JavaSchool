package delegates;

public interface Action<T, U>
{
	void invoke(T first, U second);
}
