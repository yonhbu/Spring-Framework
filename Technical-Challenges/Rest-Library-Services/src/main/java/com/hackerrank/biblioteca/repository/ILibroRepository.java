package com.hackerrank.biblioteca.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hackerrank.biblioteca.model.Libro;


@Repository
public interface ILibroRepository extends CrudRepository<Libro, Long>{
	

}
