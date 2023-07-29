package com.epam.practice.java8.practice;

public class SampleRegexPractice {

	public static void main(String[] args) {

		//System.out.println(Pattern.matches("[^amn]", "yuit"));
		//System.out.println(Pattern.matches("[a-zA-Z0-9]{6}", "arun32"));
		/*
		 * System.out.println(validate("ABCDEFabcdef123450"));
		 * System.out.println(validate("SQL")); System.out.println(validate("Java"));
		 * System.out.println(validate("*&%@#!}{"));
		 * System.out.println(validate("w3resource.com"));
		 */
		//System.out.println(validate1("1234pq"));
		System.out.println(validate2("sam_kom"));
		

	}

	public static boolean validate(String text) {
		return text.matches("^[\\w]+$");
	}
	
	public static boolean validate1(String text) {
		return text.matches("^[\\w]*pq?[\\w]?");
	}
	
	public static boolean validate2(String text) {
		return text.matches("^[a-z]+_[a-z]+[\\d]*$");
	}
	

}
