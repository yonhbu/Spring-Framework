package com.ceiba.biblioteca.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ceiba.biblioteca.model.Usuario;

@Repository
public interface IUsuarioRepository extends CrudRepository<Usuario, Long >{
	

}
