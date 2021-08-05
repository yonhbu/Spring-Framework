package com.practical.disney.services;

import java.util.List;

import com.practical.disney.model.Personaje;


public interface IPersonajeService {
	
	public List<Personaje> getConsult ();
	
	public Personaje consultId (Long id);
	
	public Personaje save (Personaje personaje);
	
	public void delete (Personaje personaje);

}	
