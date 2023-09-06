package com.revision.demo.controller;

public class Six {

	public static void main(String[] args) {
		String s1= "silent";
		String s2= "hngistlegak";
		System.out.println(validation(s1,s2));
			
	}

	private static boolean validation(String s1, String s2) {
		char[] char1 = s1.toCharArray();
		for(char ch:char1)
			if(s2.indexOf(ch) >= 0)
				return true;
		return false;
	}

}
