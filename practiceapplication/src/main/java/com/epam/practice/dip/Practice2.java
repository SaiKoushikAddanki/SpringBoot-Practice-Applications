package com.epam.practice.dip;

import java.util.stream.Stream;

public class Practice2 {

	public static void main(String[] args) {
		// find the first non-repeated character in it using Stream
		String input = "I AM A GOOD Learner ";
		int n = 2;
		String output = Stream.of(input.split("")).filter(a -> input.indexOf(a) == input.lastIndexOf(a)).skip(n - 1)
				.limit(1).findFirst().get();
		System.out.println(output);

	}

}
