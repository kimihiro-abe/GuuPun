package com.example.demo.app.forgotten_mimolette.service;

public class TodoNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public TodoNotFoundException(String message) {
		super(message);
	}

}
