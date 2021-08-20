package com.hackerrank.biblioteca.dto;


import lombok.Data;

@Data
public class UsuarioDTO {
	
	private int id;
	private String nombre;
	private String apellido; 
	private String identificacionUsuario;
	private String direccion; 
	private String telefono; 
	private String ciudad; 
	private int tipoDeUsuario;
	
	
}
