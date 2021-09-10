package com.practical.disney.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.practical.disney.model.Personaje;
import com.practical.disney.repository.IPersonajeRepository;


@Service
public class PersonajeService implements IPersonajeService{
	
	
	@Autowired
	private IPersonajeRepository iPersonajeRepository;
	

	@Override
	public List<Personaje> getConsult () {
		return (List<Personaje>) iPersonajeRepository.findAll();
	}


	@Override
	public Personaje consultId (Long id) {		
		return iPersonajeRepository.findPersonajeByIdpersonaje(id); 		
	}	
	

	@Override
	public Personaje save (Personaje personaje) {
		return iPersonajeRepository.save(personaje);
	}
	
	@Override
	public void delete (Personaje personaje) {
		iPersonajeRepository.delete(personaje);
	}
	
	public List<Personaje> getConsultByName (String nombre) {
		return (List<Personaje>) iPersonajeRepository.findPersonajeByName(nombre);
	}
	

}