package com.hackerrank.biblioteca.dto;

import lombok.Data;

@Data
public class PrestamoRequestDTO {
	
	private Long id;
	private String isbn;
    private String identificacionUsuarioBiblioteca;
    private Integer tipoUsuario;
	
}
