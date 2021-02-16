package coolcollections;

import java.util.Iterator;

import delegates.TinyFunc;
import delegates.Predicate;

public abstract class QueryableCollection<T> implements Queryable<T>
{
	public abstract Iterator<T> iterator();
	
	@Override
	public Queryable<T> where(Predicate<T> filter)
	{
		CoolList<T> filteredItems = new CoolArrayList<T>();
		
		for (T item : this)
		{
			if (filter.invoke(item))
			{
				filteredItems.add(item);
			}
		}
		
		return filteredItems;
	}

	@Override
	public <Out> Queryable<Out> select(TinyFunc<T, Out> selector)
	{
		CoolList<Out> itemsAfterSelection = new CoolArrayList<Out>();
		
		for (T item : this)
		{
			itemsAfterSelection.add(selector.invoke(item));
		}
		
		return itemsAfterSelection;
	}

	@Override
	public CoolList<T> toList()
	{	
		CoolList<T> list = new CoolArrayList<T>();
		
		for (T item : this)
		{
			list.add(item);
		}
		
		return list;
	}
}
