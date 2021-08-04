package co.com.practical.dto;

import lombok.Data;

@Data
public class Genero {
	
	private Long id;
	private String nombre;
	private PeliculaDTO peliculaAsociada;

}
