package com.ceiba.biblioteca.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Libro")
public class Libro {
	
	
	@Id()
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "idLibro")
	private Long id;	
	
	@NotBlank
	@Column (name = "Isbn")
    private String isbn;
	
	@NotBlank
	@Column (name = "Titulo")
	private String titulo;
	
	@NotBlank
	@Column (name = "Autor")
    private String autor;
	
	@NotNull
	@Column (name = "Ejemplares")
    private int ejemplares;
	
	
	
	

	

}
