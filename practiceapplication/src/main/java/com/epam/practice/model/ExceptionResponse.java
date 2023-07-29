package com.epam.practice.model;

import lombok.Data;

@Data
public class ExceptionResponse {
	
	private String message;
	private String cause;
	private String stackTrace;

}
