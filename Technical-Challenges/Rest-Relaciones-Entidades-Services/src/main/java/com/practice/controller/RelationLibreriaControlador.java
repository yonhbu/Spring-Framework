package com.practice.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.practice.model.libreria.Autor;
import com.practice.model.libreria.Libreria;
import com.practice.service.libreria.LibreriaService;





@RestController
public class RelationLibreriaControlador {


	@Autowired
	private LibreriaService libreriaService;
	
	
	
	@PostMapping("/saveLibro")
	public ResponseEntity<String> saveLibro (@RequestBody Libreria  libroRequest) {
		libreriaService.save_libro(libroRequest);
		return new ResponseEntity<>("Libro Guardado", HttpStatus.OK);
		
	}
	
	
	@GetMapping("/allLibros")
	public ResponseEntity<List<Libreria>> allLibros () {	
		return new ResponseEntity<>(libreriaService.getAll(), HttpStatus.OK);
		
	}
	
	@GetMapping("/allLibrosXAutor/{nombre}")
	public ResponseEntity<List<Autor>> allLibrosxAutor (@PathVariable("nombre") String nombre) {	
		return new ResponseEntity<>(libreriaService.findHowManyLibrosXAutorByNombre(nombre), HttpStatus.OK);
		
	}
    


}

