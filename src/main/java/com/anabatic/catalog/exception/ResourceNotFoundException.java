package com.anabatic.catalog.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class ResourceNotFoundException extends RuntimeException {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1332657865519375684L;

	public ResourceNotFoundException(String message) {
		super(message);
		
	}

}
