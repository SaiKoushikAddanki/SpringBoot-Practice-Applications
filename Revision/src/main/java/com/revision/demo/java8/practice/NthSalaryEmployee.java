package com.revision.demo.java8.practice;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.revision.demo.model.Employee;

public class NthSalaryEmployee {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		List<Employee> listEmp = StreamRealWorldProblems.generateEmpData();
		System.out.println(listEmp);
		Entry<Double, List<String>> nthEmployee = getNthEmployee(num, listEmp);
		System.out.println("\nNth highest employee name is: " + nthEmployee);
		sc.close();
	}

	private static Entry<Double, List<String>> getNthEmployee(int num, List<Employee> listEmp) {
		return listEmp.stream()
				.collect(Collectors.groupingBy(Employee::getSalary,
						Collectors.mapping(Employee::getName, Collectors.toList())))
				.entrySet().stream().sorted(Map.Entry.comparingByKey()).peek(System.out::print)
				.collect(Collectors.toList()).get(num - 1);
	}

}
