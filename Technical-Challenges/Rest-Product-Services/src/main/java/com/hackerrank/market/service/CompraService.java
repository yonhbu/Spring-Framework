package com.hackerrank.market.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hackerrank.market.model.Compra;
import com.hackerrank.market.repository.IComprasRepository;


@Service
public class CompraService implements IComprasService{
	
	@Autowired
	IComprasRepository iComprasRepository;

	@Override
	public Compra crear_Compra(Compra compra) {
		compra.getProductos().forEach(producto -> producto.setCompra(compra));
		return iComprasRepository.save(compra);
	}

	@Override
	public List<Compra> getAll() {
		return (List<Compra>) iComprasRepository.findAll();
	}

	@Override
	public Optional<List<Compra>> getByClient(String clientId) {
		return iComprasRepository.findByIdCliente(clientId);
	}



	
	
}