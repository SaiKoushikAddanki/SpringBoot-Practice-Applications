package com.epam.practice.java8.practice;

import java.util.Scanner;

public class Sample {

	public static void main(String[] args) {

		/*
		 * Scanner sc = new Scanner(System.in); int i = getInt(sc.nextInt());
		 */
		//System.out.println(4);
		//sc.close();
		Integer e = getIncrement(new Integer(4));
		System.out.println(e);

	}

	private static Integer getIncrement(Integer i) {
		return i++;
	}

	private static int getInt(int i) {
		try {
			return i + 2;
		} catch (Exception e) {
			System.out.println("Inside catch");
		} finally {
			System.out.println("Inside finally");
		}

		return i + 4;

	}

}
