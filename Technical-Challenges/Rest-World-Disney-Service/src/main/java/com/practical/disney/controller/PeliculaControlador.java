package com.practical.disney.controller;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.practical.disney.dto.PeliculaDTO;
import com.practical.disney.model.Pelicula;
import com.practical.disney.services.PeliculaService;

import lombok.extern.slf4j.Slf4j;


@RestController
@RequestMapping("/disney/pelicula")
@Slf4j
public class PeliculaControlador {

	@Autowired
	private PeliculaService peliculaService;


	@GetMapping("/peliculas")
	public ResponseEntity<List<Pelicula>> consultPeliculasOrName (@RequestParam Optional<String> titulo) {
		
		if(titulo.isPresent()) {
			return new ResponseEntity<>(peliculaService.getConsultByTitle(titulo.get()), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(peliculaService.getConsult(), HttpStatus.OK);
		}

	}


	@GetMapping("/consultId/{id}")
	public ResponseEntity<Pelicula> consulPeliculaID (@PathVariable("id") Long id) {
		log.info("Request received for findById for id=" + id);
		return new ResponseEntity<>(peliculaService.consultId(id),HttpStatus.OK);		

	}
 

	@PostMapping("/insert")
	public ResponseEntity<PeliculaDTO> insertPelicula (@RequestBody PeliculaDTO peliculaDTO) {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setAmbiguityIgnored(true);

		// convert DTO to entity
		Pelicula peliculaRequest = modelMapper.map(peliculaDTO, Pelicula.class);
		Pelicula pelicula = peliculaService.save(peliculaRequest);

		// convert entity to DTO
		PeliculaDTO peliculaResponse = modelMapper.map(pelicula, PeliculaDTO.class);
		log.info("Request received for pelicula insert", pelicula.toString());
		return new ResponseEntity<>(peliculaResponse, HttpStatus.CREATED);

	}


	@PutMapping("/update")
	public ResponseEntity<PeliculaDTO> updatePersonaje (@RequestBody PeliculaDTO peliculaDTO) {

		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setAmbiguityIgnored(true);

		// convert DTO to entity
		Pelicula peliculaRequest = modelMapper.map(peliculaDTO, Pelicula.class);
		Pelicula pelicula = peliculaService.save(peliculaRequest);

		// convert entity to DTO
		PeliculaDTO peliculaResponse = modelMapper.map(pelicula, PeliculaDTO.class);
		log.info("Request received for pelicula insert", pelicula.toString());
		return new ResponseEntity<>(peliculaResponse, HttpStatus.OK);

	}


	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deletePelicula (@PathVariable ("id") Long id) {
		Pelicula pelicula = peliculaService.consultId(id);
		peliculaService.delete(pelicula);
		log.info("Request received for pelicula deletion with id=" + id);
		return new ResponseEntity<>("Pelicula Eliminada", HttpStatus.OK);

	}


}
