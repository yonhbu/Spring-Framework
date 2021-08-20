package com.hackerrank.biblioteca.dto;

import lombok.Data;

@Data
public class PrestamoRequestDTO {
	
	private int id;
	private String isbn;
    private String identificacionUsuario;
    private int tipoUsuario;
	
}
