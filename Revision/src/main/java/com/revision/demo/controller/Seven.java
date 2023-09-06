package com.revision.demo.controller;

import java.util.ArrayList;
import java.util.List;

import com.revision.demo.model.Employee;

public class Seven {

	public static void main(String[] args) {

		Employee e1 = new Employee();
		Employee e2 = new Employee();
		Employee e3 = new Employee();
		Employee e4 = new Employee();
		List<Employee> list = new ArrayList<>();
		list.add(e1);
		list.add(e2);
		list.add(e3);
		list.add(e4);

		//Map<String, List<Employee>> sortedMap = list.stream().collect(Collectors.groupingBy(Employee::getCompanyName));
	}

}
