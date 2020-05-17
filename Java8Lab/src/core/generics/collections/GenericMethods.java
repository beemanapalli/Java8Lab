package core.generics.collections;

import static java.lang.System.out;

public class GenericMethods {
	
	/*
	 * public void testGeneric(T testString) {
	 * this line cause error as 'T' undfined becuase, generic type must be declared either at class
	 * level or at method level.
	 * Method Level: before return type <T>
	 * Class Level: after class name <T>
	 */
	public <T> void testGeneric(T testString) {
		
		out.println("Gneric method parameter : "+ testString);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenericMethods gm =new GenericMethods();
		gm.testGeneric("Good");
		

	}

}
