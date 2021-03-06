package com.hackerrank.biblioteca.controller;


import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

import com.hackerrank.biblioteca.dto.LibroDTO;
import com.hackerrank.biblioteca.dto.PrestamoRequestDTO;
import com.hackerrank.biblioteca.dto.PrestamoResponseDTO;
import com.hackerrank.biblioteca.dto.PrestamoResponseDTOByID;
import com.hackerrank.biblioteca.dto.UsuarioDTO;
import com.hackerrank.biblioteca.model.Libro;
import com.hackerrank.biblioteca.model.Prestamo;
import com.hackerrank.biblioteca.model.Usuario;
import com.hackerrank.biblioteca.service.LibroService;
import com.hackerrank.biblioteca.service.PrestamoService;
import com.hackerrank.biblioteca.service.UsuarioService;



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
		return new ResponseEntity<>(usuarioResponse, HttpStatus.OK);

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
		return new ResponseEntity<>(libroResponse, HttpStatus.OK);

	}

	@PostMapping()
	public ResponseEntity<PrestamoResponseDTO> prestarLibro (@RequestBody PrestamoRequestDTO prestamoRequestDTO){

		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setAmbiguityIgnored(true);

		//convert DTO to entity
		Prestamo prestamoRequest = modelMapper.map(prestamoRequestDTO, Prestamo.class);

		Prestamo prestamo =  prestamoService.prestar_Libro(prestamoRequest);

		if (prestamo.getTipoUsuario()==1) {
			LocalDate fechaPrestamo = LocalDate.now();
			fechaPrestamo = addDaysSkippingWeekends(fechaPrestamo, 10);
			String sDate2 = fechaPrestamo.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			prestamo.setFechaMaximaDevolucion(sDate2);

			// convert entity to DTO
			PrestamoResponseDTO prestamoResponse = modelMapper.map(prestamo, PrestamoResponseDTO.class);
			return new ResponseEntity<>(prestamoResponse, HttpStatus.OK);
		} else if (prestamo.getTipoUsuario()==2) {

			LocalDate fechaPrestamo = LocalDate.now();
			fechaPrestamo = addDaysSkippingWeekends(fechaPrestamo, 8);
			String sDate2 = fechaPrestamo.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			prestamo.setFechaMaximaDevolucion(sDate2);

			// convert entity to DTO
			PrestamoResponseDTO prestamoResponse = modelMapper.map(prestamo, PrestamoResponseDTO.class);
			return new ResponseEntity<>(prestamoResponse, HttpStatus.OK);
		} else if (prestamo.getTipoUsuario()==3) {

			LocalDate fechaPrestamo = LocalDate.now();
			fechaPrestamo = addDaysSkippingWeekends(fechaPrestamo, 7);
			String sDate2 = fechaPrestamo.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			prestamo.setFechaMaximaDevolucion(sDate2);

			// convert entity to DTO
			PrestamoResponseDTO prestamoResponse = modelMapper.map(prestamo, PrestamoResponseDTO.class);
			prestamoResponse.setId(prestamo.getId());
			return new ResponseEntity<>(prestamoResponse, HttpStatus.OK);
		} else {

			PrestamoResponseDTO prestamoResponse = modelMapper.map(prestamo, PrestamoResponseDTO.class);
			return new ResponseEntity<>(prestamoResponse, HttpStatus.OK);
		}

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


	@GetMapping("/{id}")
	public ResponseEntity<PrestamoResponseDTOByID> getPrestamosxID (@PathVariable("id") int id) {

		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setAmbiguityIgnored(true);

		Prestamo prestamo = prestamoService.getConsulPrestamoById(id);


		PrestamoResponseDTOByID prestamoResponseDTOByID = modelMapper.map(prestamo, PrestamoResponseDTOByID.class);
		return new ResponseEntity<>(prestamoResponseDTOByID, HttpStatus.OK);

	}


	public LocalDate addDaysSkippingWeekends(LocalDate date, int days) {
		LocalDate result = date;
		int addedDays = 0;
		while (addedDays < days) {
			result = result.plusDays(1);
			if (!(result.getDayOfWeek() == DayOfWeek.SATURDAY || result.getDayOfWeek() == DayOfWeek.SUNDAY)) {
				++addedDays;
			}
		}
		return result;
	}



}

