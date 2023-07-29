package com.epam.practice.java8.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import com.epam.practice.model.Passenger;
import com.epam.practice.model.Student;

public class Java8CompletePractice {

	public static void main(String[] args) {
		// Remove the duplicate charecters and return the same string in same order
		String s1 = "dabfcadef";
		s1.chars().distinct().mapToObj(u -> (char) u).forEach(System.out::print);
		System.out.println();
		String res = Stream.of(s1.split("")).distinct().collect(Collectors.joining());
		System.out.println(res);
		// find the word that has the highest length.
		String s2 = "I am interested123455 to grow in my organization";
		String res1 = Stream.of(s2.split(" ")).max(Comparator.comparing(String::length)).orElse(null);
		System.out.println(res1);
		// Given a sentence find the word that has the 2nd (Nth) highest length.
		int n = 3;
		String res2 = Stream.of(s2.split(" ")).sorted(Comparator.comparing(String::length).reversed())
				.collect(Collectors.toList()).get(n - 1);
		System.out.println(res2);
		// Find the length of the longest word
		int highestWordLength = Stream.of(s2.split(" ")).max(Comparator.comparing(String::length)).get().length();
		System.out.println(highestWordLength);
		// Given a sentence, find the number of occurrence of each word
		String s3 = "The quick brown fox jumps right over the little lazy dog little";
		Map<String, Long> groupByResult = Stream.of(s3.split(" "))
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
		System.out.println(groupByResult);
		Stream.of(s3.split(" "))
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
				.entrySet().stream().forEach(System.out::print);
		System.out.println();
		// Given a word, find the occurrence of Each Character
		Stream.of(s3.split("")).sorted(Comparator.naturalOrder())
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
				.entrySet().stream().forEach(System.out::print);
		// Given a string, find the words with the maximum number of vowels
		Arrays.stream(s3.split(" ")).filter(e -> e.replaceAll("[^aeiouAEIOU]", "").length() == 2)// **Need to look again
				.forEach(System.out::println);

		// Reverse a string with speical characters and Speical characters position
		// shouldn't be changed
		String input = "kous@#45$@";
		String reversedString = new StringBuilder(input.replaceAll("[^a-zA-Z0-9]+", "")).reverse().toString();
		String temp = input.replaceAll("[a-zA-Z0-9]", "#");
		char[] c = reversedString.toCharArray();
		for (char f : c) {
			temp = temp.replaceFirst("#", String.valueOf(f));
		}
		System.out.println(temp);

		String input1 = "kous@#45$@";
		String[] arr = input1.split("");
		String regex = "[^0-9a-zA-Z]";

		StringBuilder reversed = new StringBuilder(input1.replaceAll(regex, "")).reverse();
		IntStream.range(0, input1.length()).filter(i -> arr[i].matches(regex)).forEach(i -> reversed.insert(i, arr[i]));
		System.out.println(reversed);

		// Given a list of integers, divide into two lists one having even numbers and
		// other having odd numbers.
		List<Integer> intList = Arrays.asList(20, 43, 45, 65, 24, 68, 97);
		List<List<Integer>> listResult = intList.stream()
				.collect(Collectors.partitioningBy(a -> a % 2 == 0, Collectors.toList())).entrySet().stream()
				.map(val -> val.getValue()).collect(Collectors.toList());
		System.out.println("Even numbers are: " + listResult.get(1));
		System.out.println("Odd numbers are: " + listResult.get(0));

		// Given an array of integers (2, 34, 54, 23, 33, 20, 59, 11, 19, 37 ) group the
		// numbers by the range they belong to. The put put should be {0=[2],
		// 50=[54,59], 20=[23,20], 10=[11,19], 30=[34,33,37]}

		Map<Integer, List<Integer>> mapResult = Stream.of(2, 34, 54, 23, 33, 20, 59, 11, 19, 37)
				.collect(Collectors.groupingBy(o -> o / 10 * 10, Collectors.toList()));
		System.out.println(mapResult); // Need to look again

		// Given a List of Strings ["as", "123", "32", "2as"], create another Integer
		// list that contains only integers. The output shoul be: List<Integer> iList =
		// [123,32]
		List<String> listString = Arrays.asList("as12", "123", "32", "2as");
		List<String> numResult = new ArrayList<>();
		for (String s : listString) {
			if (s.matches("^[\\d]+$")) {
				numResult.add(s);
			}
		}
		System.out.println(numResult);

		// Given an array of integers arr = {5,6,7,8,5,5,8,8,7) find the sum of the
		// unique elements. The output should be in this case is: 26.
		int[] intArr = { 5, 6, 7, 8, 5, 5, 8, 8, 7, 4, 4 };
		int sumOfDistinct = IntStream.of(intArr).distinct().sum();
		System.out.println("Sum of distinct elements is: " + sumOfDistinct);

		// Given a numeric array , re arrange the elements to form a smallest possible
		// value. output is: 133444576998
		int arr1[] = { 1, 34, 3, 98, 9, 76, 45, 4 };
		String LeastPosNum = Arrays.stream(arr1).mapToObj(u -> u + "").sorted().collect(Collectors.joining());
		System.out.println(Long.parseLong(LeastPosNum));

		// Given a numeric array , re arrange the elements to form a highest possible
		// value
		String highestPosNum = Arrays.stream(arr1).mapToObj(u -> u + "").sorted(Comparator.reverseOrder())
				.collect(Collectors.joining());
		System.out.println(Long.parseLong(highestPosNum));

		// Given a String = The quick brown fox jumps over the lazy dog, find the first
		// non repeated character
		String firNonRepeat = Stream.of(s3.split("")).filter(a -> s3.indexOf(a) == s3.lastIndexOf(a)).findFirst().get();
		System.out.println(firNonRepeat);

		// Find the longest word in a sentence? Input: I am interested to grow in my
		// organization output is: organization
		String sentense = "I am interested to grow in my organization";
		Comparator<String> compa = (a, b) -> Integer.compare(a.length(), b.length());
		System.out.println("Laregest word in the sentense is:" + Arrays.stream(sentense.split(" ")).max(compa).get());

		// Find the lenght of the longest word
		System.out.println("Laregest word lenght in the sentense is:"
				+ Arrays.stream(sentense.split(" ")).max(compa).get().length());

		// Find the 2nd highest length in the sentence.
		int nth = 3;
		System.out.println("nth Laregest word in the sentense is:" + Arrays.stream(sentense.split(" "))
				.sorted(compa.reversed()).collect(Collectors.toList()).get(nth - 1));

		// Calcullate the lenght of each city where the city name starts with 'm' or 'M'
		// and create a list
		List<String> cityList = Arrays.asList("Mumbai", "munnar", "chennai", "Hyderabad");
		List<Integer> lenghtList = cityList.stream().filter(a -> a.matches("^[m|M][\\D]+")).map(u -> u.length())
				.collect(Collectors.toList());
		System.out.println(lenghtList);

		// Can you write a program to create another list that contains the cities start
		// with "m"
		List<String> onlyCityWithm = cityList.stream().filter(a -> a.matches("^[m][\\D]+"))
				.collect(Collectors.toList());
		System.out.println(onlyCityWithm);

		// I have to arrays write a program to check whether both arrays are equal or
		// not.
		int arr3[] = { 21, 6, 8, 9, 10, 5 };
		int arr4[] = { 21, 6, 8, 9, 10, 5 };
		int arr5[] = new int[] { 21, 6, 8, 9, 10, 5 };
		int arr2[] = { 10, 21, 5, 8, 6, 9 };
		System.out.println(Arrays.equals(arr3, arr4));

		// I have an array. Find the next greatest element for each element in a given
		// array
		int arr7[] = new int[] { 15, 10, 16, 20, 8, 9, 7, 50 };
		Arrays.sort(arr7);
		IntStream.range(0, arr7.length).forEach(i -> {
			if (i < arr7.length - 1) {
				System.out.print(arr7[i] + "-" + arr7[i + 1]);
			} else {
				System.out.println("Highest number is:" + arr7[i]);
			}

		});

		// How to remove duplicates from an arrayList?
		List<Integer> items = new ArrayList<>(Arrays.asList(1, 1, 2, 3, 3, 3, 4, 5, 6, 6, 6, 7, 8));
		Set<Integer> set = new HashSet<>(items);
		System.out.println(set);
		System.out.println(set.add(9));

		// I have a passenger Object. that has an e-mail. So given the list of passenger
		// Objects I need to find the list of domains and the no of times each domain
		// occured.
		List<Passenger> passList = Arrays.asList(new Passenger(1, "koushik", "koushik@gmail.com"),
				new Passenger(2, "komal", "komal@hotmail.com"), new Passenger(3, "surendra", "surendra@gmail.com"));
		Function<Passenger, String> fun = a -> a.getEmail().substring(a.getEmail().indexOf("@"));
		Map<String, Long> domainGrouping = passList.stream().collect(Collectors.groupingBy(fun, Collectors.counting()));
		System.out.println(domainGrouping);

		// Students least and Highest marks
		List<Student> studList = Arrays.asList(new Student("a", "maths", 90), new Student("a", "hindi", 50),
				new Student("a", "science", 70), new Student("b", "maths", 90), new Student("b", "hindi", 80),
				new Student("b", "science", 70));
		studList.stream().collect(Collectors.groupingBy(Student::getName)).entrySet().forEach(e -> {
			Student max = e.getValue().stream().max(Comparator.comparing(Student::getMarks)).get();
			Student min = e.getValue().stream().min(Comparator.comparing(Student::getMarks)).get();
			System.out.println(max.getName() + " " + max.getSubject() + " " + max.getMarks());
			System.out.println(min.getName() + " " + min.getSubject() + " " + min.getMarks());
		});

		// Left Rotate array
		int[] arr8 = { 1, 2, 3, 4, 5, 6 };
		int[] tempa = new int[arr8.length];
		int leftRotateCount = 1;
		IntStream.range(0, arr8.length).forEach(i -> {
			if (i < arr8.length - leftRotateCount) {
				tempa[i] = arr8[i + leftRotateCount];
			} else {
				tempa[i] = arr8[i - leftRotateCount * 2];
			}

		});
		for (int s : tempa)
			System.out.print(s);

		System.out.println();
		List<Passenger> passList1 = Arrays.asList(new Passenger(1, "dummy", "dummy@gmail.com"),
				new Passenger(2, "duplicate", "duplicate3@hotmail.com"), new Passenger(3, "surendra", "duplicate2@gmail.com"));
		Map<String, String> passDet = new HashMap<>();
		passList1.stream().forEach(a -> passDet.put(a.getName(), a.getEmail()));
		System.out.println(passDet);

		String initialString = "ABCD";
		stringPermuteAndPrint("", initialString);

		System.out.println();
		// Fibnocci series using stream
		Stream.iterate(new int[] { 0, 1 }, f -> new int[] { f[1], f[0] + f[1] }).limit(5).map(t -> t[0])
				.forEach(fibNum -> System.out.print(fibNum + " "));

		List<Integer> listInt = Arrays.asList(1, 0, 4, 0, 7, 0, 8, 2, 0);
		long count = listInt.stream().filter(a -> a == 0).count();
		List<Integer> arrangedList = listInt.stream().filter(a -> a != 0).collect(Collectors.toList());
		LongStream.range(0, count).forEach(i -> arrangedList.add(0));
		System.out.println(arrangedList);

	}

	private static void stringPermuteAndPrint(String prefix, String str) {
		int n = str.length();
		if (n == 0) {
			System.out.print(prefix + " ");
		} else {
			for (int i = 0; i < n; i++) {
				stringPermuteAndPrint(prefix + str.charAt(i), str.substring(i + 1, n) + str.substring(0, i));
			}
		}

	}

}
