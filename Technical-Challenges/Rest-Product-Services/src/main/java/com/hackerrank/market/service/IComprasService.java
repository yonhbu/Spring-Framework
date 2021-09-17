package com.hackerrank.market.service;

import java.util.List;
import java.util.Optional;

import com.hackerrank.market.model.Compra;




public interface IComprasService {
	
	public Compra crear_Compra (Compra compra);
	
	public List<Compra> getAll ();
	
	public Optional<List<Compra>> getByClient (String idCliente);
	


	

}
