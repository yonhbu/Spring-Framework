package com.hackerrank.biblioteca.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Prestamo")
public class Prestamo {
	
	@Id()
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "idPrestamo")
	private Long id;
	
	@NotBlank
	@Column (name = "Isbn")
    private String isbn;
	
	@NotBlank
	@Column (name = "IdentificacionUsuarioBiblioteca")
	private String identificacionUsuarioBiblioteca;
	
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "idLibro")
	private Libro libro;
	
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "idUsuario")
	private Usuario usuario;
	
	@Column (name = "TipoUsuario")
	private Integer tipoUsuario;
	
	



}
