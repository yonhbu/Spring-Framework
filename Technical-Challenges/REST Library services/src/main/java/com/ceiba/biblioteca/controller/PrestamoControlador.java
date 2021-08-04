package com.ceiba.biblioteca.controller;


import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.biblioteca.dto.LibroDTO;
import com.ceiba.biblioteca.dto.PrestamoRequestDTO;
import com.ceiba.biblioteca.dto.PrestamoResponseDTO;
import com.ceiba.biblioteca.dto.UsuarioDTO;
import com.ceiba.biblioteca.model.Libro;
import com.ceiba.biblioteca.model.Prestamo;
import com.ceiba.biblioteca.model.Usuario;
import com.ceiba.biblioteca.service.LibroService;
import com.ceiba.biblioteca.service.PrestamoService;
import com.ceiba.biblioteca.service.UsuarioService;

@RestController
@RequestMapping("prestamo")
public class PrestamoControlador {


	@Autowired
	UsuarioService usuarioService;

	@Autowired
	LibroService libroService;

	@Autowired
	PrestamoService prestamoService;


	@PostMapping("/crearUsuario")
	public ResponseEntity<UsuarioDTO> crearUsuario (@RequestBody UsuarioDTO usuarioDTO) {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setAmbiguityIgnored(true);

		// convert DTO to entity
		Usuario usuarioRequest = modelMapper.map(usuarioDTO, Usuario.class);
		Usuario usuario = usuarioService.crear_Usuario(usuarioRequest);

		// convert entity to DTO
		UsuarioDTO usuarioResponse = modelMapper.map(usuario, UsuarioDTO.class);
		return new ResponseEntity<>(usuarioResponse, HttpStatus.CREATED);

	}

	@PostMapping("/crearLibro")
	public ResponseEntity<LibroDTO> crearLibro (@RequestBody LibroDTO libroDTO){
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setAmbiguityIgnored(true);

		// convert DTO to entity
		Libro libroRequest = modelMapper.map(libroDTO, Libro.class);
		Libro libro = libroService.crear_Libro(libroRequest);

		// convert entity to DTO
		LibroDTO libroResponse = modelMapper.map(libro, LibroDTO.class);
		return new ResponseEntity<>(libroResponse, HttpStatus.CREATED);
		
	}


	@PostMapping("/prestamo")
	public ResponseEntity<PrestamoResponseDTO> prestarLibro (@RequestBody PrestamoRequestDTO prestamoDTO){

		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setAmbiguityIgnored(true);

		// convert DTO to entity
		Prestamo prestamoRequest = modelMapper.map(prestamoDTO, Prestamo.class);

		Prestamo prestamo =  prestamoService.prestar_Libro(prestamoRequest);

		// convert entity to DTO
		PrestamoResponseDTO prestamoResponse = modelMapper.map(prestamo, PrestamoResponseDTO.class);

		return new ResponseEntity<>(prestamoResponse, HttpStatus.CREATED);

	}

	@GetMapping("/getUsuarios")
	public ResponseEntity<List<Usuario>> getUsuarios () {
		return new ResponseEntity<> (usuarioService.buscar_Usuario(), HttpStatus.ACCEPTED);
	}

	@GetMapping("/getLibros")
	public ResponseEntity<List<Libro>> getLibros () {
		return new ResponseEntity<> (libroService.buscar_Libro(), HttpStatus.ACCEPTED);
	}

	@GetMapping("/getPrestamos")
	public ResponseEntity<List<Prestamo>> getPrestamos () {
		return new ResponseEntity<> (prestamoService.buscar_Prestamo(), HttpStatus.ACCEPTED);
	}
	
	
	@GetMapping("/getPrestamos/{id}")
	public ResponseEntity<Prestamo> getPrestamosxID (@PathVariable("id") Long id) {
		return new ResponseEntity<>(prestamoService.getConsulPrestamoById(id),HttpStatus.OK);		

	}


}

