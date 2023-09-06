package com.revision.demo.java8.practice;

import java.util.Arrays;
import java.util.stream.Stream;

public class CloudBerry360 {

	public static void main(String[] args) {

		Integer[] ar1 = { 1, 3, 5, 7 };
		Integer[] ar2 = { 2, 4, 6, 8 };
		Stream.of(ar1, ar2).flatMap(Stream::of).sorted().forEach(System.out::print);

		String name = "koushik";
		char[] chars = name.toCharArray();
		char[] result = new char[name.length()];
		int count = 0;
		for (int i = 0; i < chars.length; i++) {
			if (i % 2 == 0) {
				result[count] = chars[i];
				++count;
			}

		}
		
		System.out.println(String.valueOf(result).toUpperCase());

	}

}
