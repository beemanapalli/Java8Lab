package com.lambdas;

import static java.lang.System.*;

interface lambdaTest{
	void PrintOut(String s);
}

public class SyntaxExamples {
	
	
	public static void main(String args[]) {
		lambdaTest t =(s)->out.println(s +"   ->called lambda implementation"); //this is implementation of Interface lambdaTest
		t.PrintOut("Test");   // calling above implementation
		
		
	}

}
