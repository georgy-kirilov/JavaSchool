package coolcollections;

import delegates.TinyFunc;
import delegates.TinyAction;
import delegates.Predicate;

public interface Queryable<T> extends Iterable<T>
{
	Queryable<T> where(Predicate<T> filter);
	
	<Out> Queryable<Out> select(TinyFunc<T, Out> selector);
	
	<C extends Comparable<C>> Queryable<T> sortBy(TinyFunc<T, C> func);
	
	<C extends Comparable<C>> Queryable<T> sortByDescending(TinyFunc<T, C> func);
	
	CoolList<T> toList();
	
	T firstOrDefault(Predicate<T> filter);
	
	boolean any(Predicate<T> filter);
	
	boolean all(Predicate<T> filter);
	
	void each(TinyAction<T> action);
	
	String join(String separator);
	
	int count();
}
