package coolcollections;

import java.util.Iterator;

import coolcollections.lists.ArrayList;
import coolcollections.lists.List;
import delegates.Func;
import delegates.Action;
import delegates.TinyFunc;
import delegates.Predicate;
import delegates.TinyAction;

public abstract class QueryableCollection<TSource> implements Queryable<TSource>
{
	public abstract Iterator<TSource> iterator();
	
	/*@Override
	public Queryable<TSource> where(Predicate<TSource> filter)
	{
		List<TSource> filteredItems = new ArrayList<TSource>();
		
		for (TSource item : this)
		{
			if (filter.invoke(item))
			{
				filteredItems.add(item);
			}
		}
		
		return filteredItems;
	}

	@Override
	public <TOut> Queryable<TOut> select(TinyFunc<TSource, TOut> selector)
	{
		List<TOut> itemsAfterSelection = new ArrayList<TOut>();
		
		for (TSource item : this)
		{
			itemsAfterSelection.add(selector.invoke(item));
		}
		
		return itemsAfterSelection;
	}
	
	@Override
	public <TKey extends Comparable<TKey>> Queryable<TSource> sortBy(TinyFunc<TSource, TKey> func)
	{
		List<TSource> list = this.toList();
		this.quickSort(list, func, true);
		return list;
	}
	
	@Override
	public <TKey extends Comparable<TKey>> Queryable<TSource> sortByDescending(TinyFunc<TSource, TKey> func)
	{
		List<TSource> list = this.toList();
		this.quickSort(list, func, false);
		return list;
	}
	
	@Override
	public List<TSource> toList()
	{	
		List<TSource> list = new ArrayList<TSource>();
		
		for (TSource item : this)
		{
			list.add(item);
		}
		
		return list;
	}
	
	@Override
	public TSource firstOrDefault(Predicate<TSource> filter)
	{
		for (TSource item : this)
		{
			if (filter.invoke(item))
			{
				return item;
			}
		}
		
		return null;
	}

	@Override
	public boolean any(Predicate<TSource> filter)
	{
		for (TSource item : this)
		{
			if (filter.invoke(item))
			{
				return true;
			}
		}
		
		return false;
	}
	
	@Override
	public boolean all(Predicate<TSource> filter)
	{
		for (TSource item : this)
		{
			if (!filter.invoke(item))
			{
				return false;
			}
		}
		
		return true;
	}
	
	@Override
	public Queryable<TSource> each(TinyAction<TSource> action)
	{
		for (TSource item : this)
		{
			action.invoke(item);
		}
		
		return this;
	}
	
	@Override
	public String join(String separator)
	{	
		final String defaultSeparator = ", ";
		
		if (separator == null)
		{
			separator = defaultSeparator;
		}
		
		StringBuilder sb = new StringBuilder();
		
		for (TSource item : this)
		{
			sb.append(item);
			sb.append(separator);
		}
		
		String result = sb.toString();
		int index = result.lastIndexOf(separator);
		
		if (index != -1)
		{
			result = result.substring(0, result.length() - separator.length());
		}
		
		return result;
	}
	
	@Override
	@SuppressWarnings("unused")
	public int count()
	{
		int count = 0;
		
		for (TSource item : this)
		{
			count++;
		}
		
		return count;
	}
	
	private <C extends Comparable<C>> void quickSort(List<TSource> list, TinyFunc<TSource, C> func, boolean ascending)
	{
		Func<Integer, Integer, Integer> partition = new Func<Integer, Integer, Integer>()
		{
			@Override
			public Integer invoke(Integer low, Integer high)
			{
				TSource pivot = list.get(high);
		        int i = (low - 1);
		        
		        for (int j = low; j < high; j++) 
		        { 
		        	boolean shouldSwap = ascending && func.invoke(list.get(j)).compareTo(func.invoke(pivot)) < 0 
		        			|| !ascending && func.invoke(list.get(j)).compareTo(func.invoke(pivot)) > 0;
		        	
		            if (shouldSwap)
		            { 
		                i++;
		                TSource temp = list.get(i); 
		                list.set(i, list.get(j));
		                list.set(j, temp);
		            } 
		        } 
		  
		        TSource temp = list.get(i + 1); 
		        list.set(i + 1, list.get(high));
		        list.set(high, temp);
		        return i + 1; 
			}
		};
		
		Action<Integer, Integer> sort = new Action<Integer, Integer>()
		{
			@Override
			public void invoke(Integer low, Integer high)
			{
				if (low < high) 
		        { 
		            int pi = partition.invoke(low, high);
		            this.invoke(low, pi - 1); 
		            this.invoke(pi + 1, high);
		        }
			}
	    };
	    
	    sort.invoke(0, list.count() - 1);
	}*/
}
