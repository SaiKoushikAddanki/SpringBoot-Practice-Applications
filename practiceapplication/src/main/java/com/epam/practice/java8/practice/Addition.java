package com.epam.practice.java8.practice;

class Manipulation { // Super class
	public void add(String name) { // String parameter
	}
}

public class Addition extends Manipulation {

	public void add(String name) {// No Parameter
	}

	public void add(int a) { // integer parameter

	}

	public static void main(String args[]) {
		Addition addition = new Addition();
		//addition.add();
	}
}
