package com.strings;

public class StringNEW {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = new String("Hello");  
		String s2 = new String("Hello");

	}

}

/*
HERE 3 objects crerated.

First - line 1, "Hello" object in the string pool.
Second - line 1, new String with value "Hello" in the heap memory.
Third - line 2, new String with value "Hello" in the heap memory. Here "Hello" string from string pool is reused.
*/