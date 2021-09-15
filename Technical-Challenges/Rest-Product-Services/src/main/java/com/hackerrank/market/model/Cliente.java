package com.hackerrank.market.model;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
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
	@Column (name = "cliente_id")
	private String idCliente;
	
	private String nombre;
	
	private String apellidos;
	
	private Long celular;
	
	private String direccion;
	
	private String email;
	
	
	//Relacion uno a Muchos (Clientes con Compras)
	
	@OneToMany(mappedBy = "cliente")
	private List<Compra> listaCompras;
	
	


}
