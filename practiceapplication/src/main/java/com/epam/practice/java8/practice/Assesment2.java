package com.epam.practice.java8.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import org.springframework.util.StringUtils;

public class Assesment2 {

	public static void main(String[] args) {

		String input = "cat is jumping on tree cat is a cat of such a cat !!! cat is a hard for catch in the cat of  a cat all the cat";
		List<String> words = Arrays.asList(input.split(" "));
		IntStream.range(0, words.size()).filter(a -> words.get(a).equals("cat")).map(a -> a + 1).boxed()
				.forEach(System.out::println);
		words.stream().filter(a -> a.equals("cat")).map(a -> words.indexOf(a)).forEach(System.out::println);
		System.out.println("Concurrent occurence value is: " + StringUtils.countOccurrencesOf(input, "cat"));

		List<Integer> indexes = new ArrayList<>();
		for (int i = 0; i < words.size(); i++) {
			if (words.get(i).equals("cat")) {
				indexes.add(i + 1);
			}
		}
		System.out.println(indexes);

	}

}
