package com.practical.disney.services;

import java.util.List;
import com.practical.disney.model.Pelicula;




public interface IPeliculaService {
	
	public List<Pelicula> getConsult ();
	
	public Pelicula consultId (Long id);
	
	public Pelicula save (Pelicula pelicula);
	
	public void delete (Pelicula pelicula);
	
	

}	
