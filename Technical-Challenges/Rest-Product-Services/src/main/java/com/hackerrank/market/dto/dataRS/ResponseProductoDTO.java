package com.hackerrank.market.dto.dataRS;


import java.io.Serializable;


import lombok.Data;

@Data
public class ResponseProductoDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer idProducto;
	private String nombre;
	private Integer categoriaProducto;
	private String codigoBarras;
	private Double precioVenta;
	private int cantidadStock;
	private Boolean estado;


}
