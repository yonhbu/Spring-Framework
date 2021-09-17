package com.hackerrank.market.dto.dataRS;


import java.io.Serializable;


import lombok.Data;

@Data
public class ResponseCompraProductoDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private ResponseCompraProductoPKDTO id;

	private Integer cantidad;
	private Double total;
	private String estado;

	

	
	

}
