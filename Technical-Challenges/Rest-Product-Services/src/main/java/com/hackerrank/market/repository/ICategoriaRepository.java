package com.hackerrank.market.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.hackerrank.market.model.Categoria;



@Repository
public interface ICategoriaRepository extends CrudRepository<Categoria, Integer>{
	
	

}
