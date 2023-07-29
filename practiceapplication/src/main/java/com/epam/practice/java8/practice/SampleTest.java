package com.epam.practice.java8.practice;

import java.util.Map.Entry;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SampleTest {

	public static void main(String[] args) {
		String s1 = "hi koushik  Addanki";

		Predicate<Entry<Character, Long>> pre = a -> a.getValue() > 1;
		Stream.of(s1.split("")).map(a -> a.charAt(0)).collect(Collectors.groupingBy(u -> u, Collectors.counting()))
			.entrySet().stream()
				.filter(pre).forEach(System.out::print);

	}

}
