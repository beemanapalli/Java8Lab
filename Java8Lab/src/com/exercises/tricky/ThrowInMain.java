package com.exercises.tricky;

import java.io.IOException;

public class ThrowInMain {

	public static void main(String[] args) {
		try {
			throw new IOException("Hello");
		}catch(  Exception e) {
			System.out.println(e.getMessage());
		}
	}

	}

 /*
  * It prints Hello 
  * 
  */
