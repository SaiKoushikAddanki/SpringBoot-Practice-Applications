package com.koushik.latest.springlatestupdates.practice;

import java.util.function.BiFunction;
import java.util.function.Function;

public class ReturnFunctionsDemo {

	protected static class MyMath {
		public static Integer timesTwo(Integer a) {
			return a * 2;
		}

		public static Integer timesThree(Integer a) {
			return a * 3;
		}

		public static Integer timesFour(Integer a) {
			return a * 4;
		}

		public static Function<Integer, Integer> createMultiplier(Integer a) {
			return (Integer x) -> x * a;
		}
	}

	public static void main(String[] args) {
		NoArgsFun<NoArgsFun<String>> createGreater = () -> () -> "Hello funckers!!";
		NoArgsFun<String> creater = createGreater.perform();
		System.out.println(creater.perform());

		Function<Integer, Integer> timesTwo = MyMath.createMultiplier(2);
		Function<Integer, Integer> timesThree = MyMath.createMultiplier(3);
		Function<Integer, Integer> timesFour = MyMath.createMultiplier(4);
		System.out.println(timesTwo.apply(6));
		System.out.println(timesThree.apply(6));
		System.out.println(timesFour.apply(6));

		// Higher order classes
		BiFunction<Integer, Integer, Integer> divide = (x, y) -> x / y;
		Function<BiFunction<Integer, Integer, Integer>, BiFunction<Integer, Integer, Integer>> secondArgValidator = (
				func) -> (x, y) -> {
					if (y == 0) {
						System.out.println("Second arg is zero");
						return 0;
					}

					return func.apply(x, y);
				};
		// BinaryOperator<Integer> divideSafe = secondArgValidator.apply(divide);
		BiFunction<Integer, Integer, Integer> divideSafe = secondArgValidator.apply(divide);
		System.out.println(divideSafe.apply(20, 0));

	}

}
