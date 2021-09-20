package com.practice.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.practice.model.employee.Empleado;
import com.practice.service.employee.EmpleadoService;





@RestController
public class RelationEmployeeControlador {


	@Autowired
	private EmpleadoService empleadoService;
	
	
	
	@PostMapping("/saveEmpleado")
	public ResponseEntity<String> saveEmpleado (@RequestBody List<Empleado> empleadoRequest) {
		empleadoService.crear_Empleado(empleadoRequest);
		return new ResponseEntity<>("Empleado Guardado", HttpStatus.OK);
		
	}
	
	
	@GetMapping("/allEmpleado")
	public ResponseEntity<List<Empleado>> allEmpleado () {	
		return new ResponseEntity<>(empleadoService.getAll(), HttpStatus.OK);
		
	}
    


}

