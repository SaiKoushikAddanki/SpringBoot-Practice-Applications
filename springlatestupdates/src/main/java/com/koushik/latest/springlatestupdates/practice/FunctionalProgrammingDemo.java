package com.koushik.latest.springlatestupdates.practice;


import java.util.function.BiFunction;
import java.util.function.Function;

public class FunctionalProgrammingDemo {

    public static void main(String[] args) {
        System.out.println("Start of the main method");
        Function<Integer, Boolean> myMath = MyMath::triple;
        Boolean result = myMath.apply(11);
        System.out.println("Result is: " + result);
        Function<String, Integer> myStrLen = (str1) -> {
            Integer twiceLen = str1.length() * 2;
            return twiceLen;
        };
        System.out.println("Twice length is: " + myStrLen.apply("koushik"));

        BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;
        System.out.println("Sum of the 2 numbers is: " + add.apply(34, 32));

        TriFunction<Integer, Integer, Integer, Integer> addThree = (a, b, c) -> a + b + c;
        System.out.println("Sum of three num is :" + addThree.perform(2, 22, 43));

    }

    public static class MyMath {
        public static Boolean triple(Integer num) {
            return num % 2 == 0;
        }
    }

}
