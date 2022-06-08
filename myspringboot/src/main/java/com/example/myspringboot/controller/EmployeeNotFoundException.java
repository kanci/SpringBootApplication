package com.example.myspringboot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class EmployeeNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public EmployeeNotFoundException() {
		
	}
	
	public EmployeeNotFoundException(String message) {
		super(message);
	}
	
	public EmployeeNotFoundException(Throwable cause) {
		super(cause);
	}
	
	public EmployeeNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public EmployeeNotFoundException(String message, Throwable cause, boolean enableSuppresion, boolean writableStackTrace) {
		super(message, cause, enableSuppresion, writableStackTrace);
	}
	
}
