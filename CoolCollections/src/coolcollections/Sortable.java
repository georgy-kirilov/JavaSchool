package coolcollections;

import java.util.Comparator;

import delegates.TinyFunc;

public interface Sortable<TSource>
{
	Queryable<TSource> sortBy(Comparator<TSource> comparator);
	
	<TKey extends Comparable<TKey>> Queryable<TSource> sortBy(TinyFunc<TSource, TKey> keySelector);
	
	Queryable<TSource> sortByDesc(Comparator<TSource> comparator);
	
	<TKey extends Comparable<TKey>> Queryable<TSource> sortByDesc(TinyFunc<TSource, TKey> keySelector);
}
