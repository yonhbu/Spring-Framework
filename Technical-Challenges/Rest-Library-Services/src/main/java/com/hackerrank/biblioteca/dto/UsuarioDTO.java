package com.hackerrank.biblioteca.dto;


import lombok.Data;

@Data
public class UsuarioDTO {
	
	private Long id;
	private String nombre;
	private String apellido; 
	private String identificacionBiblioteca;
	private String direccion; 
	private String telefono; 
	private String ciudad; 
	private Integer tipoDeUsuario;
	
	
}
