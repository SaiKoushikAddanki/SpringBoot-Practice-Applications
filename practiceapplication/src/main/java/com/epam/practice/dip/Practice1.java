package com.epam.practice.dip;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Practice1 {

	public static void main(String[] args) {
		String s1 = "apple, banana, orange, elephant, iguana, octopus, unicorn";
		Predicate<String> preReg = a -> a.matches("^[aeiou][\\w]+");
		Predicate<String> pre = a -> a.startsWith("a");
		Predicate<String> pre1 = a -> a.startsWith("e");
		Predicate<String> pre2 = a -> a.startsWith("i");
		Predicate<String> pre3 = a -> a.startsWith("o");
		Predicate<String> pre4 = a -> a.startsWith("u");
		Predicate<String> preFinal = pre.or(pre1).or(pre2).or(pre3).or(pre4);
		Comparator<String> com = Comparator.comparing(a -> a.length());

		String s2 = Stream.of(s1.split(", ")).filter(preReg).map(a -> a.toUpperCase()).sorted(com.reversed())
				.collect(Collectors.joining(","));
		System.out.println(s2);

		String s3 = "The quick brown fox jumps over the lazy dog, find the first non repeated character";

		for (Character e : s3.toCharArray()) {
			if (s3.indexOf(e) == s3.lastIndexOf(e)) {
				System.out.println("First non repeating charecter is: " + e);
				break;
			}
		}

		List<String> nonDuplicateCharecters = new ArrayList<>();
		Stream.of(s3.split("")).forEach(a -> {
			if (s3.indexOf(a) == s3.lastIndexOf(a)) {
				nonDuplicateCharecters.add(a);
			}
		});
		System.out.println("All non duplicates are:" + nonDuplicateCharecters);

		int n = 4;
		Predicate<Entry<Character, Long>> pre5 = h -> h.getValue() == 1L;
		Stream.of(s3.split("")).map(u -> Character.valueOf(u.charAt(0)))
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
				.entrySet().stream().filter(pre5).skip(n).limit(1).map(a -> a.getKey()).forEach(a -> {
					System.out.println("nth non repeating charecter " + a);
				});
		Predicate<Character> predic = a -> s3.indexOf(a) == s3.lastIndexOf(a);
		s3.chars().mapToObj(a -> (char) a).filter(predic).skip(1).limit(1).forEach(System.out::println);

	}

}
