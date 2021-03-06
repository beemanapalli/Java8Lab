package com.exercises.tricky;

public class Null_Overload {

	public static void main(String[] args) {
		method(null);
	}
	public static void method(Object o) {
		System.out.println("Object impl");
	}
	public static void method(String s) {
		System.out.println("String impl");
	}
	
	/*
	 * According to java specs, in case of overloading, compiler picks the most specific function. 
	 * Obviously String class is more specific that Object class, hence it will print �String impl�.
	 */

	/*
	 * What if we have another method in the class like below
	 * public static void method(StringBuffer i){
		System.out.println("StringBuffer impl");
	}
	In this case, java compiler will throw error as �The method method(String)
	 is ambiguous for the type Test� because String and StringBuffer, none of them are more specific to others. A method is more specific than another if any invocation handled by the first method could be passed on to the other one without a compile-time type error. We can pass String as parameter to Object argument and String argument but not to StringBuffer argument method.
	 */
	
}
