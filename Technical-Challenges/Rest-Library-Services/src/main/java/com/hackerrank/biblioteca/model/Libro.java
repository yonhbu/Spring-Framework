package com.hackerrank.biblioteca.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

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
	private int id;	
	
	@NotBlank
	@Pattern(regexp = "^[A-Za-z0-9]+$")
	@Size(min=1, max=10)
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
