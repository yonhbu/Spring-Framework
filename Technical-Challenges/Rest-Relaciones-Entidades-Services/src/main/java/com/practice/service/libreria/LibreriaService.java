package com.practice.service.libreria;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.model.libreria.Autor;
import com.practice.model.libreria.Libreria;
import com.practice.repository.libreria.IAutorRepository;
import com.practice.repository.libreria.ILibreriaRepository;



@Service
public class LibreriaService implements ILibreriaService{
	
	@Autowired
	ILibreriaRepository iLibreriaRepository;
	
	@Autowired
	IAutorRepository iAutorRepository;

	@Override
	public Libreria save_libro (Libreria libro) {
		return iLibreriaRepository.save(libro);
	}

	@Override
	public List<Libreria> getAll() {
		return iLibreriaRepository.findAll();
	}

	@Override
	public List<Autor> findHowManyLibrosXAutorByNombre(String nombre) {
		return iAutorRepository.findByNombre(nombre);
	}
	

	


	
	
}