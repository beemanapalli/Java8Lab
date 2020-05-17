package com.exercises.tricky;

import java.util.HashSet;

public class ShortIntCasting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet shortSet = new HashSet();
		for (short i = 0; i < 100; i++) {
			
			shortSet.add(i);
			shortSet.remove(i - 1);
		}

		System.out.println(shortSet.size());

	}

}

/*

The size of the shortSet will be 100. Java Autoboxing feature has been introduced in JDK 5, so while adding the short to HashSet<Short> it will automatically convert it to Short object. Now "i-1" will be converted to int while evaluation and after that it will autoboxed to Integer object but there are no Integer object in the HashSet, so it will not remove anything from the HashSet and finally its size will be 100.
*/