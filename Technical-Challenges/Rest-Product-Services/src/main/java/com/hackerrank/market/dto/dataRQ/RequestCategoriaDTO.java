package com.hackerrank.market.dto.dataRQ;


import java.io.Serializable;

import lombok.Data;

@Data
public class RequestCategoriaDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;


	private String descripcion;
	private Boolean estado;
	
	

}
