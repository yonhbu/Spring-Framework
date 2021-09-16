package com.practice.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.practice.model.Direccion;




@Repository
public interface IDireccionRepository extends CrudRepository<Direccion, Integer>{
	
	

}
