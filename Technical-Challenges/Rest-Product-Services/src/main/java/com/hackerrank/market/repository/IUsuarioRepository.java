package com.hackerrank.market.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hackerrank.market.model.Usuario;




@Repository
public interface IUsuarioRepository extends CrudRepository<Usuario, Integer>{
	

}
