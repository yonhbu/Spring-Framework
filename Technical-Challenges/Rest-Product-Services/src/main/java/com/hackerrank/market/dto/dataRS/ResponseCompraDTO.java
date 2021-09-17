package com.hackerrank.market.dto.dataRS;


import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;

@Data
public class ResponseCompraDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String idCliente;
	private LocalDateTime fecha;
	private String medioPago;
	private String comentario;
	private String estado;
	private List<ResponseCompraProductoDTO> productos;
	

}
