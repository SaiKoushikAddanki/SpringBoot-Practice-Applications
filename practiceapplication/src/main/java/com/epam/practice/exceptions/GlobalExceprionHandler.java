package com.epam.practice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.epam.practice.model.ExceptionResponse;

@ControllerAdvice
public class GlobalExceprionHandler {

	@ResponseBody
	@ExceptionHandler(ReadOnlyFileException.class)
	@ResponseStatus(code = HttpStatus.LOCKED)
	public ExceptionResponse handleReadOnlyFileException(ReadOnlyFileException ex) {
		ExceptionResponse exResponse = new ExceptionResponse();
		exResponse.setMessage(ex.getMessage());
		exResponse.setCause(ex.getCause().toString());
		exResponse.setStackTrace(ex.getStackTrace().toString());
		return exResponse;
	}

}
