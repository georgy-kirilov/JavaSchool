package delegates;

public interface Predicate<T>
{
	boolean invoke(T argument);
}
