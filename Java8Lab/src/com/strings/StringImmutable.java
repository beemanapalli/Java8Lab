package com.strings;

public class StringImmutable {

	public static void main(String[] args) {

       String s ="abc";
       String s2 =s;
       System.out.println("s2 : "+s2);
       s=s.concat("def");
       System.out.println("s : "+s);
       System.out.println("s2 : "+s2);
       
     

	}

}
