package com.hackerrank.biblioteca.dto;


import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class PrestamoResponseDTOByID {
	
	private int id;
	private String isbn;
    private String identificacionUsuario;
    private int tipoUsuario;
    
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private String fechaMaximaDevolucion; 
	
}
