package com.hackerrank.biblioteca.service;



import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackerrank.biblioteca.model.Libro;
import com.hackerrank.biblioteca.repository.ILibroRepository;



@Service
public class LibroService implements ILibroService{
	
	@Autowired
	ILibroRepository iLibroRepository;

	@Autowired
	UsuarioService usuarioService;
	
	
	@Override
	public Libro crear_Libro(Libro libro) {
		return iLibroRepository.save(libro);
	}

	@Override
	public List<Libro> buscar_Libro() {
		return (List<Libro>) iLibroRepository.findAll();
	}



}