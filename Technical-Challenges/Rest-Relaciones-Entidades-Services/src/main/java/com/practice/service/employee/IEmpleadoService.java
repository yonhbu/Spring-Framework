package com.practice.service.employee;

import java.util.List;

import com.practice.model.employee.Empleado;




public interface IEmpleadoService {
	
	public List<Empleado> crear_Empleado (List<Empleado> empleadoRequest);
	
	public List<Empleado> getAll ();
	


	

}
