package com.practice.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.practice.model.Empleado;



@Repository
public interface IEmpleadoRepository extends CrudRepository<Empleado, Integer>{
	
	

}
