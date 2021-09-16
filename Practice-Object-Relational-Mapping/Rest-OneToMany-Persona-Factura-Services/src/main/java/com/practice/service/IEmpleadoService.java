package com.practice.service;

import java.util.List;

import com.practice.model.Empleado;




public interface IEmpleadoService {
	
	public List<Empleado> crear_Empleado (List<Empleado> empleadoRequest);
	
	public List<Empleado> getAll ();
	


	

}
