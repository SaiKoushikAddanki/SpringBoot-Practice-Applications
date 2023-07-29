package com.epam.practice.java8.practice;

import java.util.function.BiFunction;

public class FunctionalProgrammingDemo2 {

	protected static class MyMath {
		public static Integer add(Integer a, Integer b) {
			return a + b;
		}

		public static Integer subtract(Integer a, Integer b) {
			return a - b;
		}

		public static Integer combine2and3(BiFunction<Integer, Integer, Integer> combine) {
			return combine.apply(2, 3);
		}

	}

	public static void main(String[] args) {

		System.out.println(MyMath.combine2and3(MyMath::add));
		System.out.println(MyMath.combine2and3(MyMath::subtract));
		System.out.println(MyMath.combine2and3((x, y) -> 2 * x + 2 * y));
	}

}
