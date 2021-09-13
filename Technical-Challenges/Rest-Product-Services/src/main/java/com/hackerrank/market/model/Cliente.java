package com.hackerrank.market.model;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
@Table(name="Cliente")
public class Cliente {
	
	@Id()
	private String id;
	
	private String nombre;
	private String apellidos;
	private Long celular;
	private String direccion;
	private String email;
	
	
	//Relacion uno a Muchos (Clientes con Compras)
	
	@OneToMany(mappedBy = "cliente")
	private List<Compra> listaCompras;
	
	


}
