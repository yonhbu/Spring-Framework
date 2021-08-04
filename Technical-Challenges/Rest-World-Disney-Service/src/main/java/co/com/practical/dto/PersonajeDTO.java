package co.com.practical.dto;

import lombok.Data;

@Data
public class PersonajeDTO {
	
	private Long id;
	private String nombre;
	private int edad;
	private int peso;
	private String historia;
	private PeliculaDTO peliculas;

}
