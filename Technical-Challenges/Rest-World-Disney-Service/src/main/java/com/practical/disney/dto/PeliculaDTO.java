package com.practical.disney.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class PeliculaDTO {
	
	private String titulo;
	private LocalDate fechaCreacion;
	private int calificacion;

}
