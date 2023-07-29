package com.epam.practice.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Passenger {
	
	private Integer id;
	private String name;
	private String email;

}
