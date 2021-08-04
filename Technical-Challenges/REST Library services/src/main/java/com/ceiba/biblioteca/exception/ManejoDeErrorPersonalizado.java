package com.ceiba.biblioteca.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;




@ControllerAdvice
public class ManejoDeErrorPersonalizado extends ResponseEntityExceptionHandler  {
	
	public ManejoDeErrorPersonalizado() {
		super();
	}
	
	
	@ExceptionHandler(value = {ClienteNoEncontrado.class})
	public final ResponseEntity<Object> clienteNoEncontrado (ClienteNoEncontrado clienteNoEncontrado, WebRequest request) {      
		MensajeDeErrorPersonalizado responseError = new MensajeDeErrorPersonalizado ("cliente no encontrado en la base de datos");  
		return new ResponseEntity<>(responseError, HttpStatus.NOT_FOUND);
	}
	

	@ExceptionHandler(value = {NoStockDisponibles.class})
	public final ResponseEntity<Object> noStockDisponibles (NoStockDisponibles noStockDisponibles, WebRequest request) {      
		MensajeDeErrorPersonalizado responseError = new MensajeDeErrorPersonalizado ("No se tiene stock del libro en el  momento");  
		return new ResponseEntity<>(responseError, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = {IsbnNoExiste.class})
	public final ResponseEntity<Object> isbnNoExiste (IsbnNoExiste isbnNoExiste, WebRequest request) {      
		MensajeDeErrorPersonalizado responseError = new MensajeDeErrorPersonalizado ("ISBN No existe Favor validar nuevamente");  
		return new ResponseEntity<>(responseError, HttpStatus.NOT_FOUND);
	}
	

	@ExceptionHandler(value = {UsuarioNoPuedePrestarLibro.class})
	public final ResponseEntity<Object> usuarioNoPuedePrestarLibro (UsuarioNoPuedePrestarLibro usuarioNoPuedePrestarLibro, WebRequest request) {  
		MensajeDeErrorPersonalizado responseError = new MensajeDeErrorPersonalizado ("El usuario con la identificaci�n ingresada ya tiene un libro prestado por lo cual no se le puede realizar otro pr�stamo ");  
		return new ResponseEntity<>(responseError, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = {ValidarTipoUsuarioValido.class})
	public final ResponseEntity<Object> validarTipoUsuarioValido (ValidarTipoUsuarioValido validarTipoUsuarioValido, WebRequest request) {      
		MensajeDeErrorPersonalizado responseError = new MensajeDeErrorPersonalizado ("Tipo de usuario no permitido en la biblioteca");  
		return new ResponseEntity<>(responseError, HttpStatus.BAD_REQUEST);
	}
	
	
	
	
	

}


