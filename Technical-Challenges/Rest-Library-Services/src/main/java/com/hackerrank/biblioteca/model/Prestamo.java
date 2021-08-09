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
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

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
	@Pattern(regexp = "^[A-Za-z0-9]+$")
	@Size(min=1, max=10)
	@Column (name = "Isbn")
    private String isbn;
	
	@NotBlank
	@Pattern(regexp = "^[A-Za-z0-9]+$")
	@Size(min=1, max=10)
	@Column (name = "IdentificacionUsuario")
	private String identificacionUsuario;
	
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "idLibro")
	private Libro libro;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	@Column (name = "FechaMaximaDevolucion")
	private String fechaMaximaDevolucion;
	
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "idUsuario")
	private Usuario usuario;
	
	@Column (name = "TipoUsuario")
	private int tipoUsuario;
	
	



}
