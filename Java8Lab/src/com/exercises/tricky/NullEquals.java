package com.exercises.tricky;

public class NullEquals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str = null;
		String str1="abc";
		System.out.println(str1.equals("abc") | str.equals(null));
	//	System.out.println(  str.equals(null) || str1.equals("abc"));
		//	System.out.println(str1.equals("abc") || str.equals(null));

	}

}

/*
The given print statement will throw java.lang.NullPointerException because while evaluating the OR logical operator it will first evaluate both the literals and since str is null, .equals() method will throw exception. Its always advisable to use short circuit logical operators i.e "||" and "&&" which evaluates the literals values from left and since the first literal will return true, it will skip the second literal evaluation.
second comments will cause null pointer exception, because first evaluation will lead to null pointer exception
Third line will run without error, prints true
*/