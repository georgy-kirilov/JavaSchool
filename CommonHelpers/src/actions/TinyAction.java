package actions;

public interface TinyAction<T>
{
	void invoke(T argument);
}
