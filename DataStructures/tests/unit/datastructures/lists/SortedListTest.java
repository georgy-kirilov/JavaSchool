package unit.datastructures.lists;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import datastructures.lists.SortedLinkedList;
import datastructures.lists.SortedList;

public class SortedListTest
{
	private SortedList<Integer> list = new SortedLinkedList<>();
	
	@Before
	public void setUp()
	{
		this.list.clear();
	}
	
	@Test
	public void Add_Should_IncreaseSize()
	{
		for (int i = 0; i < 5; i++)
		{
			assertEquals(i, this.list.size());
			this.list.add(i);
		}
	}
	
	@Test
	public void Add_Should_AddSingleItemCorrectly()
	{
		int number = 0;
		this.list.add(number);
		
		assertEquals(1, this.list.size());
		
		for (int item : this.list)
		{
			assertTrue(item == number);			
		}
	}
	
	@Test
	public void Add_ForAscendingOrder_Should_AddMultipleItemsCorrectly()
	{
		int[] itemsToAdd = new int[] { 0, 2, 1, 1, -5, 3, 8, 0, -1 };
		
		for (int itemToAdd : itemsToAdd)
		{
			this.list.add(itemToAdd);
		}
		
		Arrays.sort(itemsToAdd);
		assertEquals(itemsToAdd.length, this.list.size());
		
		int index = 0;
		
		for (int item : this.list)
		{
			assertTrue(item == itemsToAdd[index]);
			index++;
		}
	}
	
	/*@Test
	public void Add_ForDescendingOrder_Should_AddMultipleItemsCorrectly()
	{
		this.list = new SortedLinkedList<>(false);
		Integer[] itemsToAdd = new Integer[] { 0, 2, 1, 1, -5, 3, 8, 0, -1 };
		
		for (int itemToAdd : itemsToAdd)
		{
			this.list.add(itemToAdd);
		}

		Arrays.sort(itemsToAdd, Collections.reverseOrder());
		assertEquals(itemsToAdd.length, this.list.size());
		
		int index = 0;
		
		for (int item : this.list)
		{
			assertTrue(item == itemsToAdd[index]);
			index++;
		}
	}*/
}
