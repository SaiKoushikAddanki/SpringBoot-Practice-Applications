package com.epam.practice.java8.practice;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProgrammingPractice {

	public static void main(String[] args) {
		// programme to swap 2 numbers using 3rd.
		int a = 3, b = 4, temp;
		System.out.println("Before swapping: " + a + b);
		temp = a;
		a = b;
		b = temp;
		System.out.println("After swapping: " + a + b);

		// programme to swap 2 numbers without 3rd
		int c = 5, d = 10;
		System.out.println("Before swap: " + c + d);
		c = c + d;
		d = c - d;
		c = c - d;
		System.out.println("After swap is: " + c + d);

		// to count the each word occurence in a string

		String str = "This this is is done by Saket Saket";
		Map<String, Long> result = Stream.of(str.split(" "))
				.collect(Collectors.groupingBy(co -> co, Collectors.counting()));
		System.out.println(result);

		// Hashmap iteration
		Map<Integer, String> map = new HashMap<>();
		map.put(2, "Saket");
		map.put(25, "Saurav");
		map.put(12, "HashMap");
		System.out.println(map.size());
		System.out.println("While Loop:");
		Iterator<Entry<Integer, String>> itr = map.entrySet().iterator();
		System.out.println("Print in while loop");
		while (itr.hasNext()) {
			Entry<Integer, String> e = itr.next();
			System.out.println("Key is:" + e.getKey() + "and value is:  " + e.getValue());
		}
		System.out.println("Print in the for loop");
		for (Map.Entry<Integer, String> e : map.entrySet()) {
			System.out.println("Key is:" + e.getKey() + "and value is:  " + e.getValue());
		}

		// prime number programme
		int mod, num = 13;
		boolean isPrime = true;
		/*
		 * System.out.println("Enter a value: "); Scanner in = new Scanner(System.in);
		 * num = in.nextInt();
		 */
		for (int s = 2; s <= num / 2; s++) {
			mod = num % s;
			if (mod == 0) {
				isPrime = false;
				break;
			}
		}
		if (isPrime) {
			System.out.println("Given number is Prime");
		} else {
			System.out.println("Given number is not Prime");
		}
		// palindrome
		int l = 10;
		int start = 0, next = 0, si = 1;
		for (int s = 0; s <= l; s++) {
			start = next;
			next = si;
			si = start + next;
			System.out.print(start + " ");
		}
		System.out.println();

		// duplicate charecters in a string
		String str1 = "Sai Koushik Addanki";
		Predicate<Entry<Character, Long>> pre = e -> e.getValue() > 1;
		Stream.of(str1.split("")).map(u -> u.charAt(0)).collect(Collectors.groupingBy(g -> g, Collectors.counting()))
				.entrySet().stream().filter(pre).forEach(System.out::print);
		System.out.println();
		//second highest nuber
		int[] secondHighest = {4, 45, 74,87,97,64,72,92, 100};
		int largest=0, seconfLargest=0;
		for(int i=0; i<secondHighest.length; i++) {
			if(secondHighest[i]> largest) {
				seconfLargest = largest;
				largest=secondHighest[i];
			} else if(secondHighest[i]> seconfLargest) {
				seconfLargest = secondHighest[i];
			}
		}
		System.out.println("Second highest number is: " + seconfLargest);
		
		//Amstrong number
		int amstrong = 1634, m=0, q=0, pow=0;
		if(amstrong>=1000 && amstrong<10000) {
			pow =4;
		} else if(amstrong>100 && amstrong<1000) {
			pow=3;
		} else {
			pow=2;
		}
		for(int i=amstrong; i>0;) {
				m=i%10;
				q+=(int) Math.pow(m, pow);
				i= i/10;			
		}
		System.out.println(q);
		if(q == amstrong) {
			System.out.println("Number is Amstrong");
		} else {
			System.out.println("Number is not Amstrong");
		}
		
		//Remove spaces waing replace
		String str2= "Saket Saurav        is a QualityAna    list";
		Stream.of(str2.split("")).map(f -> f.charAt(0)).filter(g -> g != ' ').forEach(System.out::print);
		System.out.println();
		
		//find first non repeating charecter
		String str3 = "Sai Koushik Addanki";
		Predicate<Entry<Character, Long>> pre1 = e -> e.getValue() == 1;
		Entry<Character, Long> firstNonDuplicate = Stream.of(str3.split("")).map(u -> u.charAt(0)).collect(Collectors.groupingBy(g -> g, LinkedHashMap::new, Collectors.counting()))
				.entrySet().stream().filter(pre1).findFirst().get();
		System.out.println("First non duplocate char is: " + firstNonDuplicate.getKey());
		
		//

	}

}
