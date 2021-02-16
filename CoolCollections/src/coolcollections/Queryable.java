package coolcollections;

import delegates.TinyFunc;
import delegates.Predicate;

public interface Queryable<T> extends Iterable<T>
{
	Queryable<T> where(Predicate<T> filter);
	
	<Out> Queryable<Out> select(TinyFunc<T, Out> selector);
	
	CoolList<T> toList();
	
	boolean any(Predicate<T> filter);
	
	String join(String separator);
}
