package com.practical.disney.dto;

import java.util.List;

import com.practical.disney.model.Pelicula;

import lombok.Data;

@Data
public class PersonajeRQDTO {
	
	private String nombre;
	private Integer edad;
	private Integer peso;
	private String historia;
	//private List<Pelicula> peliculaID;

}
