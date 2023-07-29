package com.epam.practice.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {
	private String name;
	private String subject;
	private Integer marks;
}
