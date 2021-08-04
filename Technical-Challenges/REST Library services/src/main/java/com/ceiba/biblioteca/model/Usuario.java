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
@Table(name="Usuario")
public class Usuario {
	
	@Id()
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "idUsuario")
	private Long id;
	
	@NotBlank
	@Column (name = "Nombre")
	private String nombre;
	
	@NotBlank
	@Column (name = "Apellido")
	private String apellido; 
	
	@NotBlank
	@Column (name = "IdentificacionBiblioteca")
	private String identificacionBiblioteca;
	
	@NotBlank
	@Column (name = "Direccion")
	private String direccion; 
	
	@NotBlank
	@Column (name = "Telefono")
	private String telefono; 
	
	@NotBlank
	@Column (name = "Ciudad")
	private String ciudad; 
	
	
	// 1 Usuario Afiliado
	// 2 Usuario Empleado de la Biblioteca
	// 3 Usuario Invitado
	
	@NotNull
	@Column (name = "TipoDeUsuario")
	private Integer tipoDeUsuario;
	
	


}
