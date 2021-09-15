package com.hackerrank.market.dto.dataRS;


import java.io.Serializable;

import lombok.Data;

@Data
public class ResponseCategoriaDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Integer idCategorias;
	private String descripcion;
	private Boolean estado;
	
	

}
