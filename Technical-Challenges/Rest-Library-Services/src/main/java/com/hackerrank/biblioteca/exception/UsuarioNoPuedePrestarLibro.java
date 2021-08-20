package com.hackerrank.biblioteca.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UsuarioNoPuedePrestarLibro extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	public UsuarioNoPuedePrestarLibro (String message) {
	    super(message);
	  }
		
}