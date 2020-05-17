package com.advanced;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.junit.Assert.assertEquals;

public class ElementOrdering {
	List<Integer> numbers = asList(1,2,3,4);
	
	
	public void encounterOrderList() {
		List<Integer> stillOrder =numbers.stream().map(x -> x+1).collect(toList());
		assertEquals(asList(2,3,4,5),stillOrder);
		
		/*
		 * assertEquals(asList(1,3,4,5),stillOrder); --> Produces Exception in thread "main" java.lang.AssertionError: expected:<[1, 3, 4, 5]> but was:<[2, 3, 4, 5]>
		 * assertEquals(asList(2,3,4,5),stillOrder); --> Produces no error
		 * assertEquals(asList(2,3,4,5),hasItem(2)); --> Throws java.lang.AssertionError: expected:<[2, 3, 4, 5]> but was:<a collection containing <2>>
		 */
		
		
	}
	
	public void encounterOrderSet() {
		Set<Integer> unOrder =new HashSet(numbers);
		List<Integer> stillUnOrder =unOrder.stream().map(x -> x+1).collect(toList());
		
		//assertEquals(stillUnOrder,hasItem(2));  --> Throws java.lang.AssertionError: expected:<[2, 3, 4, 5]> but was:<a collection containing <2>>
		assertEquals(asList(2,3,4,5),stillUnOrder);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ElementOrdering ft =new ElementOrdering();
		ft.encounterOrderList();
		//ft.encounterOrderSet();

	}

}
