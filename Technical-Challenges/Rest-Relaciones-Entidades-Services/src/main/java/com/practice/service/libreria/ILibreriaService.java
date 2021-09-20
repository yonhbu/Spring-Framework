package com.practice.service.libreria;

import java.util.List;

import com.practice.model.libreria.Autor;
import com.practice.model.libreria.Libreria;




public interface ILibreriaService {
	
	public Libreria save_libro (Libreria libro);
	
	public List<Libreria> getAll ();
	
    public List<Autor> findHowManyLibrosXAutorByNombre (String nombre);

	

}
