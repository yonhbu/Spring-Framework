package com.hackerrank.market.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.hackerrank.market.model.Categoria;



@Repository
public interface ICategoriaRepository extends CrudRepository<Categoria, Integer>{
	
	

}
