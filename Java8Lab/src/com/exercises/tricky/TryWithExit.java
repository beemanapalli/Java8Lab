package com.exercises.tricky;

public class TryWithExit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			if (false) {
				while (true) {
				}
			} else {
			//	return;
		 	System.out.println("Exit without going to finally");
		 	 	System.exit(1);
			}
		} finally {
			System.out.println("In Finally");
		}
	}

}

/*

1.The finally block will never be reached here. If flag will be TRUE, it will go into an infinite loop and if its false its exiting the JVM. So finally block will never be reached here.

2.//	return; will cause error that next lines will not be reached, if no next lines then finally will execute.

*/