package com.practice.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.model.Direccion;
import com.practice.repository.IDireccionRepository;



@Service
public class DireccionService implements IDireccionService{
	
	@Autowired
	IDireccionRepository iFacturaRepository;

	@Override
	public Direccion crear_Direccion (Direccion direccion) {
		return iFacturaRepository.save(direccion);
	}

	@Override
	public List<Direccion> getAll() {
		return (List<Direccion>) iFacturaRepository.findAll();
	}


	
}