package com.practical.disney.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.practical.disney.model.Pelicula;
import com.practical.disney.repository.IPeliculaRepository;


@Service
public class PeliculaService implements IPeliculaService{
	
	
	@Autowired
	private IPeliculaRepository iPeliculaRepository;
	

	@Override
	public List<Pelicula> getConsult () {
		return (List<Pelicula>) iPeliculaRepository.findAll();
	}
	
	public List<Pelicula> getConsultByTitle (String titulo) {
		return (List<Pelicula>) iPeliculaRepository.findPeliculaByTitulo(titulo);
	}
	
	@Override
	public Pelicula save (Pelicula pelicula) {
		return iPeliculaRepository.save(pelicula);
	}
	
	@Override
	public void delete (Pelicula pelicula) {
		iPeliculaRepository.delete(pelicula);
	}

	@Override
	public Pelicula consultId(Long id) {
		return iPeliculaRepository.findPeliculaByidpelicula(id); 		
	}
	


}