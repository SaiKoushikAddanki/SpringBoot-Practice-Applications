package com.epam.practice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Employee implements Cloneable {

	int id;
    String name;
    int age;
    String gender;
    String department;
    int yearOfJoining;
    double salary;
	
	
}
