package com.hackerrank.market.model;


import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class ComprasProductosPK implements Serializable { //Clase con primary key compuesta
	

	private static final long serialVersionUID = 1L;
	
	private Integer idCompra;
	private Integer idProducto;
	


}
