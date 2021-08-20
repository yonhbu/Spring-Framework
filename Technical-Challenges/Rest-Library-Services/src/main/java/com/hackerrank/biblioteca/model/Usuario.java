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
@Table(name="Usuario")
public class Usuario {
	
	@Id()
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "idUsuario")
	private int id;
	
	@NotBlank
	@Column (name = "Nombre")
	private String nombre;
	
	@NotBlank
	@Column (name = "Apellido")
	private String apellido; 
	
	@NotBlank
	@Pattern(regexp = "^[A-Za-z0-9]+$")
	@Size(min=1, max=10)
	@Column (name = "IdentificacionUsuario")
	private String identificacionUsuario;
	
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
	private int tipoDeUsuario;
	
	


}
