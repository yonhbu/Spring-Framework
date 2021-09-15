package com.hackerrank.market.service;

import java.util.List;

import com.hackerrank.market.dto.dataRS.ResponseClienteDTO;
import com.hackerrank.market.model.Cliente;




public interface IClienteService {
	
	public Cliente crear_Cliente (Cliente cliente);
	
	public List<ResponseClienteDTO> getAll ();
	


	

}
