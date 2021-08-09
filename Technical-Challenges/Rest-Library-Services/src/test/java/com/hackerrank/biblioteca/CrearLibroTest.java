package com.hackerrank.biblioteca;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CrearLibroTest {

	private Long id;	
    private String isbn;
	private String titulo;
    private String autor;
    private int ejemplares;
    
}
