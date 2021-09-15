package com.hackerrank.market.model;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class ComprasProductosPK implements Serializable { //Clase con primary key compuesta
	

	private static final long serialVersionUID = 1L;
	
	@Column (name = "id_compra")
	private Integer idCompras;
	
	@Column (name = "id_producto")
	private Integer idProductos;
	


}
