package com.hackerrank.market.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.hackerrank.market.model.Compra;



@Repository
public interface IComprasRepository extends CrudRepository<Compra, Integer>{
	
	//Esto es un Query Method
	Optional<List<Compra>> findByIdCliente (String idCliente);

}
