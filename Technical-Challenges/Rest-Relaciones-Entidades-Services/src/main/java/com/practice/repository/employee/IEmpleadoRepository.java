package com.practice.repository.employee;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.practice.model.employee.Empleado;



@Repository
public interface IEmpleadoRepository extends CrudRepository<Empleado, Integer>{


}
