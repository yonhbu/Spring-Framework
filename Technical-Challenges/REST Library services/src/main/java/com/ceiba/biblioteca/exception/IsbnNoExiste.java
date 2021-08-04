package com.ceiba.biblioteca.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class IsbnNoExiste extends RuntimeException{
  
	private static final long serialVersionUID = 1L;


}