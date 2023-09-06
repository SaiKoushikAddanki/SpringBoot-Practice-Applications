package com.revision.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

	int id;
    String name;
    int age;
    String gender;
    String department;
    int yearOfJoining;
    double salary;
	
	
}
