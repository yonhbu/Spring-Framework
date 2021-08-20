package com.hackerrank.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hackerrank.biblioteca.model.Prestamo;




@Repository
public interface IPrestamoRepository extends JpaRepository<Prestamo, Integer>{
	
	Prestamo findPrestamoById(int id);

}
