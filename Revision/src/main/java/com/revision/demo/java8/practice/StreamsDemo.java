package com.revision.demo.java8.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamsDemo {

	public static void main(String[] args) {

		System.out.println("Working on the stream");
		Integer[] intArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		List<Integer> list = new ArrayList<Integer>(Arrays.asList(intArray));
		Function<Integer, Integer> timesTwo = (x) -> x * 2;
		List<Integer> doubled = list.stream().map(timesTwo).collect(Collectors.toList());
		System.out.println(doubled.toString());

		Predicate<Integer> isEven = (x) -> x % 2 == 0;
		List<Integer> even = list.stream().filter(isEven).collect(Collectors.toList());
		System.out.println("List of even numbers are: " + even);

		String[] stringArray = { "hi", "hello", "how are you", "what the fuck", "koushik" };
		List<String> words = new ArrayList<String>(Arrays.asList(stringArray));
		Predicate<String> stringLength = (x) -> x.length() > 5;
		List<String> sorted = words.stream().filter(stringLength).collect(Collectors.toList());
		System.out.println(sorted);

		Function<Integer, Predicate<String>> lenghtValidator = (validLenght) -> (str) -> str.length() > validLenght;
		Predicate<String> isLenghtMore3 = lenghtValidator.apply(3);
		List<String> sorted1 = words.stream().filter(isLenghtMore3).collect(Collectors.toList());
		System.out.println(sorted1);

		BinaryOperator<Integer> getSum = (acc, x) -> {
			Integer res = acc + x;
			System.out.println("Acc is:" + acc + "and x is: " + x);
			return res;
		};
		System.out.println(list.stream().reduce(getSum));

		Map<Integer, List<String>> map = words.stream().collect(Collectors.groupingBy(

				(word) -> word.length()

		));

		System.out.println(map);

	}

}
