package com.bayram.exception;

import java.io.Serializable;

public class UserAlreadyExistException extends RuntimeException implements Serializable {
	
	private static final long serialVersionUID = 1L;

	public UserAlreadyExistException(String message) {
		super(message);
	}
	
	

}
