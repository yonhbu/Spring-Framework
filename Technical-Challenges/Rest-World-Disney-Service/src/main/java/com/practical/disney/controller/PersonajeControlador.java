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

import com.practical.disney.dto.PersonajeRQDTO;
import com.practical.disney.model.Personaje;
import com.practical.disney.services.PersonajeService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/disney/personaje")
public class PersonajeControlador {

	@Autowired
	private PersonajeService personajeService;


	@GetMapping("/characters")
	public ResponseEntity<List<Personaje>> consultPersonajesOrName (@RequestParam Optional<String> nombre) {
		
		if(nombre.isPresent()) {
			return new ResponseEntity<>(personajeService.getConsultByName(nombre.get()), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(personajeService.getConsult(), HttpStatus.OK);
		}

	}


	@GetMapping("/consultId/{id}")
	public ResponseEntity<Personaje> consulPersonajeID (@PathVariable("id") Long id) {
		return new ResponseEntity<>(personajeService.consultId(id),HttpStatus.OK);		

	}
 

	@PostMapping("/insert")
	public ResponseEntity<PersonajeRQDTO> insertPersonaje (@RequestBody PersonajeRQDTO personajeDTO) {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setAmbiguityIgnored(true);

		// convert DTO to entity
		Personaje personajeRequest = modelMapper.map(personajeDTO, Personaje.class);
		Personaje personaje = personajeService.save(personajeRequest);

		// convert entity to DTO
		PersonajeRQDTO personajeResponse = modelMapper.map(personaje, PersonajeRQDTO.class);
		return new ResponseEntity<>(personajeResponse, HttpStatus.CREATED);

	}


	@PutMapping("/update")
	public ResponseEntity<PersonajeRQDTO> updatePersonaje (@RequestBody PersonajeRQDTO personajeDTO) {

		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setAmbiguityIgnored(true);

		// convert DTO to entity
		Personaje personajeRequest = modelMapper.map(personajeDTO, Personaje.class);
		Personaje personaje = personajeService.save(personajeRequest);

		// convert entity to DTO
		PersonajeRQDTO personajeResponse = modelMapper.map(personaje, PersonajeRQDTO.class);
		return new ResponseEntity<>(personajeResponse, HttpStatus.OK);

	}


	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deletePersonaje (@PathVariable ("id") Long id) {
		Personaje personaje = personajeService.consultId(id);
		personajeService.delete(personaje);
		return new ResponseEntity<>("Personaje Eliminado", HttpStatus.OK);

	}


}
