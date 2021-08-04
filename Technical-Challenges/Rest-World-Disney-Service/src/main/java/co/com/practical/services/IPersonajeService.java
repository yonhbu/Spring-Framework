package co.com.practical.services;

import java.util.List;

import co.com.practical.model.Personaje;

public interface IPersonajeService {
	
	public List<Personaje> getConsult ();
	
	public Personaje getConsultId (Long id);
	
	public Personaje save_Personaje (Personaje personaje);
	
	public void delete_Personaje (Personaje personaje);

}	
