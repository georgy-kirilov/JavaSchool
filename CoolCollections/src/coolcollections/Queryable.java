package coolcollections;

import delegates.TinyFunc;
import delegates.TinyAction;
import delegates.Predicate;

public interface Queryable<TSource> extends Iterable<TSource>
{
	Queryable<TSource> where(Predicate<TSource> filter);
	
	<TOut> Queryable<TOut> select(TinyFunc<TSource, TOut> selector);
	
	<TKey extends Comparable<TKey>> Queryable<TSource> sortBy(TinyFunc<TSource, TKey> func);
	
	<TKey extends Comparable<TKey>> Queryable<TSource> sortByDescending(TinyFunc<TSource, TKey> func);
	
	TSource firstOrDefault(Predicate<TSource> filter);
	
	boolean any(Predicate<TSource> filter);
	
	boolean all(Predicate<TSource> filter);
	
	Queryable<TSource> each(TinyAction<TSource> action);
	
	String join(String separator);
	
	CoolList<TSource> toList();
	
	int count();
}
