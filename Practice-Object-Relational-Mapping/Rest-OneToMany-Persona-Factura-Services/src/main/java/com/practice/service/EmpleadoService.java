package com.practice.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.model.Empleado;
import com.practice.repository.IEmpleadoRepository;



@Service
public class EmpleadoService implements IEmpleadoService{
	
	@Autowired
	IEmpleadoRepository iPersonaRepository;
	

	@Override
	public List<Empleado> crear_Empleado(List<Empleado> empleadoRequest) {
		return (List<Empleado>) iPersonaRepository.saveAll(empleadoRequest);
	}

	@Override
	public List<Empleado> getAll() {
		return (List<Empleado>) iPersonaRepository.findAll();
	}

	


	
	
}