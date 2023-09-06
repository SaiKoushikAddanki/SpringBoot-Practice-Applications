package com.revision.demo.java8.practice;

import java.util.Arrays;
import java.util.List;

import org.springframework.util.StringUtils;

public class Assesment2 {

	public static void main(String[] args) {

		String input = "cat is jumping on tree cat is a cat of such a cat !!! cat is a hard for catch in the cat of  a cat all the cat";
		List<String> words = Arrays.asList(input.split(" "));
		 words.stream().filter(a -> a.equals("cat")).map(a -> words.indexOf(a)).forEach(System.out::println);
		 System.out.println(StringUtils.countOccurrencesOf(input, "cat"));

		
		/*
		 * List<Integer> indexes = new ArrayList<>(); for (int i = 0; i < words.size();
		 * i++) { if (words.get(i).equals("cat")) { indexes.add(i+1); } }
		 * System.out.println(indexes);
		 */

	}

}
