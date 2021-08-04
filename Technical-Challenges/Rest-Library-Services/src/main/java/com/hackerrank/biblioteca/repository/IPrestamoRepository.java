package com.hackerrank.biblioteca.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hackerrank.biblioteca.model.Prestamo;

@Repository
public interface IPrestamoRepository extends CrudRepository<Prestamo, Long>{
	
	Prestamo findPrestamoById(Long id);

}
