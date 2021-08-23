package com.hackerrank.gevents.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EventDoesNotExistException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	public EventDoesNotExistException (int message) {
	    super();
	  }
	
}