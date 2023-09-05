package com.dolzanes.domain.exception;


@SuppressWarnings("serial")
public class ObjectNotFoundException extends RuntimeException {
	
	public ObjectNotFoundException(String message) {
		super(message);
	}
}
