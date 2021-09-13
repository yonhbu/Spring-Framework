package com.hackerrank.market.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackerrank.market.model.Categoria;
import com.hackerrank.market.repository.ICategoriaRepository;


@Service
public class CategoriaService implements ICategoriaService{
	
	@Autowired
	ICategoriaRepository iCategoriaRepository;

	@Override
	public Categoria crear_Categoria(Categoria categoria) {
		return iCategoriaRepository.save(categoria);
	}

	@Override
	public List<Categoria> getAll() {
		return (List<Categoria>) iCategoriaRepository.findAll();
	}

	
	
}