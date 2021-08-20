package com.hackerrank.biblioteca.service;

import java.util.List;

import com.hackerrank.biblioteca.model.Libro;



public interface ILibroService {
	
	public Libro crear_Libro (Libro libro);
	public List<Libro> buscar_Libro ();
	

}
