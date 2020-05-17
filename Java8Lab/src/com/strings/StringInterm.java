package com.strings;

public class StringInterm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s1 = "abc";
		String s2 = new String("abc");
		s2.intern();//----->1
		System.out.println(s1 ==s2); //----->2
		
		s2=s2.intern();//----->3
		System.out.println(s1 ==s2); //----->4

	}

}

/*

It's a tricky question and output will be false. We know that intern() method will return 
the String object reference from the string pool, but since we didn't assigned it back to s2, 
there is no change in s2 and hence2= both s1 and s2 are having different reference. If we change the code in line 3 to s2 = s2.intern(); then output will be true.

we reassigned s2 with s2.interm(), hence we get true at #4
*/