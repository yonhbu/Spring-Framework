package com.practice.service.employee;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.model.employee.Empleado;
import com.practice.repository.employee.IEmpleadoRepository;



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