package coolcollections;

import java.util.Iterator;

import delegates.TinyFunc;
import delegates.Action;
import delegates.Func;
import delegates.Predicate;
import delegates.TinyAction;

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
	public <C extends Comparable<C>> Queryable<T> sortBy(TinyFunc<T, C> func)
	{
		CoolList<T> list = this.toList();
		this.quickSort(list, func, true);
		return list;
	}
	
	@Override
	public <C extends Comparable<C>> Queryable<T> sortByDescending(TinyFunc<T, C> func)
	{
		CoolList<T> list = this.toList();
		this.quickSort(list, func, false);
		return list;
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
	
	@Override
	public T firstOrDefault(Predicate<T> filter)
	{
		for (T item : this)
		{
			if (filter.invoke(item))
			{
				return item;
			}
		}
		
		return null;
	}

	@Override
	public boolean any(Predicate<T> filter)
	{
		for (T item : this)
		{
			if (filter.invoke(item))
			{
				return true;
			}
		}
		
		return false;
	}
	
	@Override
	public boolean all(Predicate<T> filter)
	{
		for (T item : this)
		{
			if (!filter.invoke(item))
			{
				return false;
			}
		}
		
		return true;
	}
	
	@Override
	public Queryable<T> each(TinyAction<T> action)
	{
		for (T item : this)
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
		
		for (T item : this)
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
		
		for (T item : this)
		{
			count++;
		}
		
		return count;
	}
	
	private <C extends Comparable<C>> void quickSort(CoolList<T> list, TinyFunc<T, C> func, boolean ascending)
	{
		Func<Integer, Integer, Integer> partition = new Func<Integer, Integer, Integer>()
		{
			@Override
			public Integer invoke(Integer low, Integer high)
			{
				T pivot = list.get(high);
		        int i = (low - 1);
		        
		        for (int j = low; j < high; j++) 
		        { 
		        	boolean shouldSwap = ascending && func.invoke(list.get(j)).compareTo(func.invoke(pivot)) < 0 
		        			|| !ascending && func.invoke(list.get(j)).compareTo(func.invoke(pivot)) > 0;
		        	
		            if (shouldSwap)
		            { 
		                i++;
		                T temp = list.get(i); 
		                list.set(i, list.get(j));
		                list.set(j, temp);
		            } 
		        } 
		  
		        T temp = list.get(i + 1); 
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
	}
}
