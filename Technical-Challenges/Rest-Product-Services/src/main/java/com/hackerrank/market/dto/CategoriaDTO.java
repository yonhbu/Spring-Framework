package com.hackerrank.market.dto;


import java.io.Serializable;

import lombok.Data;

@Data
public class CategoriaDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;


	private String descripcion;
	private Boolean estado;
	
	

}
