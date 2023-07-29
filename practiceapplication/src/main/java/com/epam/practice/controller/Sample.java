package com.epam.practice.controller;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.epam.practice.model.Employee;

public class Sample {

	public static void main(String[] args) {
		System.out.println(getNthMaxSal(null, 5));
	}

	private static Employee getNthMaxSal(List<Employee> empList, int n) {

		Comparator<Employee> com = Comparator.comparing(Employee::getSalary);
		List<Employee> sortedSalList = empList.stream().filter(a -> a.getGender().equals("Male")).sorted(com)
				.collect(Collectors.toList());
		return sortedSalList.get(n - 1);
	}

}
