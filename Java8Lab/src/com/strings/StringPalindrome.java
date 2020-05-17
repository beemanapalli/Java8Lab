package com.strings;

public class StringPalindrome {

	 private static boolean isPalindrome(String str) {
	        if (str == null)
	            return false;
	        StringBuilder strBuilder = new StringBuilder(str);
	        strBuilder.reverse();
	        return strBuilder.toString().equals(str);
	    }
	 private static boolean isPalindromeString(String str) {
	        if (str == null)
	            return false;
	        int length = str.length();
	        System.out.println("Length:"+length / 2);
	        System.out.println("Lenght/2:"+length / 2);
	        for (int i = 0; i < length / 2; i++) {

	            if (str.charAt(i) != str.charAt(length - i - 1))
	                return false;
	        }
	        return true;
	    }
	public static void main(String[] args) {
	//	System.out.println(StringPalindrome.isPalindrome("aba"));
		System.out.println(StringPalindrome.isPalindromeString("abba"));

	}

}
