package com.strings;

public class StringStringBufferEqu {

	public static void main(String[] args) {
		String s1 = "abc";
		StringBuffer s2 = new StringBuffer(s1);
		System.out.println(s1.equals(s2));

	}

}

/*
It will print false because s2 is not of type String. 
If you will look at the equals method implementation in the String class, 
you will find a check using instanceof operator to check if the type of passed object is String? 
If not, then return false.
*/