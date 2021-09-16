package com.hackerrank.market.dto.dataRS;


import java.io.Serializable;

import lombok.Data;

@Data
public class ResponseClienteDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;


	private String idCliente;
	private String nombre;
	private String apellidos;
	private Long celular;
	private String direccion;
	private String email;

	

}
