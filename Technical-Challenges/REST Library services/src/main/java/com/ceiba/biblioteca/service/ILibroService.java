package com.ceiba.biblioteca.service;




import java.util.List;
import com.ceiba.biblioteca.model.Libro;


public interface ILibroService {
	
	public Libro crear_Libro (Libro libro);
	public List<Libro> buscar_Libro ();
	

}
