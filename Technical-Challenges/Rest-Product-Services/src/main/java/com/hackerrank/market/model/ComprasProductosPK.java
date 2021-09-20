package com.hackerrank.market.model;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;


@Data
@Embeddable
public class ComprasProductosPK implements Serializable { //Clase con primary key compuesta
	

	private static final long serialVersionUID = 1L;
	

	@Column(name = "id_compras")
	private Integer idCompras;
	
	@Column(name = "id_productos")
	private Integer idProductos;
	


}
