package coolcollections;

import delegates.TinyFunc;
import delegates.TinyAction;
import delegates.Predicate;

public interface Queryable<T> extends Iterable<T>
{
	Queryable<T> where(Predicate<T> filter);
	
	<Out> Queryable<Out> select(TinyFunc<T, Out> selector);
	
	CoolList<T> toList();
	
	T firstOrDefault(Predicate<T> filter);
	
	boolean any(Predicate<T> filter);
	
	boolean all(Predicate<T> filter);
	
	void each(TinyAction<T> action);
	
	String join(String separator);
}
