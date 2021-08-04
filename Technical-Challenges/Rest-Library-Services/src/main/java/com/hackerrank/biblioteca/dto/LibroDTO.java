package com.hackerrank.biblioteca.dto;


import lombok.Data;

@Data
public class LibroDTO {
	
	private Long id;
    private String isbn;
	private String titulo;
    private String autor;
    private int ejemplares;
	
	
}
