package com.hackerrank.market.dto.dataRQ;


import java.io.Serializable;

import lombok.Data;

@Data
public class RequestProductoDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String nombre;
	private Integer categoriaProducto;
	private String codigoBarras;
	private Double precioVenta;
	private int cantidadStock;
	private Boolean estado;


}
