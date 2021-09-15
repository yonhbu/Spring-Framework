package com.hackerrank.market.dto.dataRQ;


import java.io.Serializable;

import lombok.Data;

@Data
public class RequestClienteDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;


	private String id;
	private String nombre;
	private String apellidos;
	private Long celular;
	private String direccion;
	private String email;



}
