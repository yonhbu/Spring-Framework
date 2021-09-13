package com.hackerrank.market.model;


import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name="Compras_Producto")
public class ComprasProducto {
	
	@EmbeddedId
	private ComprasProductosPK id;  // Instanciamos la clase que tiene primary key compuesta
	
	private Integer cantidad;
	private Double total;
	private Boolean estado;
	
	@ManyToOne
	@JoinColumn (name = "idCompra", insertable = false, updatable = false)
	private Compra compra;
	
	
	@ManyToOne
	@JoinColumn (name = "idProducto", insertable = false, updatable = false)
	private Producto producto;
	

	

	
	
	


}
