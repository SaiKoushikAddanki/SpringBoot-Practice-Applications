package com.epam.practice.exceptions;

public class ReadOnlyFileException extends RuntimeException {

	public ReadOnlyFileException(String message) {
		super(message);
	}
}
