package com.ask.solutions.elastic.responsemodel;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ApiResponse<T> {
	private HttpStatus status;
	private String message;
	private T data;
}
