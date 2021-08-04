package com.hackerrank.biblioteca.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hackerrank.biblioteca.model.Usuario;

@Repository
public interface IUsuarioRepository extends CrudRepository<Usuario, Long >{
	

}
