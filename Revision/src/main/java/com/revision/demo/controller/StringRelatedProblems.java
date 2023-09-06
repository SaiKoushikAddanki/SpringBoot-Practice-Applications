package com.revision.demo.controller;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringRelatedProblems {

	public static void main(String[] args) {
		
		String[] words = {"Sai", "Koushik", "Addanki", "Komal"};
		System.out.println(Stream.of(words).sorted().collect(Collectors.toList()));
		System.out.println((int) 'a' -96);
		String word = "koushik";
		int result=0;
		for(int i=0; i<word.length(); i++) {
			result+=(int) word.charAt(i) - 96;
			System.out.println(result);
		}
		System.out.println("Lucky number is: " + result);
		
		
	}

}
