package com.hackerrank.market.dto;


import java.io.Serializable;

import com.hackerrank.market.model.Categoria;

import lombok.Data;

@Data
public class ProductoDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String nombre;
	private int idCategoria;
	private String codigoBarras;
	private Double precioVenta;
	private int cantidadStock;
	private Boolean estado;
    private Categoria categoria;


}
