package com.hackerrank.market.dto;


import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import com.hackerrank.market.model.Cliente;
import com.hackerrank.market.model.ComprasProducto;

import lombok.Data;

@Data
public class RequestCompraDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String idCliente;
	private LocalDateTime fecha;
	private String medioPago;
	private String comentario;
	private String estado; //Si la orden ya se pago o no
	private Cliente cliente;
	private List<ComprasProducto> comprasProducto;
	
	

}
