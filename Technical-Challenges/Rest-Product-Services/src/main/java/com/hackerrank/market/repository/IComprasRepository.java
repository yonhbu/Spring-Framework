package com.hackerrank.market.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.hackerrank.market.model.Compra;
import com.hackerrank.market.model.ComprasProductosPK;



@Repository
public interface IComprasRepository extends CrudRepository<Compra, ComprasProductosPK>{
	
	//Esto es un Query Method
	Optional<List<Compra>> findByIdCliente (String idCliente);

}
