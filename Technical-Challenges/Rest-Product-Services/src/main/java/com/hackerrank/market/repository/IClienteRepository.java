package com.hackerrank.market.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.hackerrank.market.model.Cliente;



@Repository
public interface IClienteRepository extends CrudRepository<Cliente, Integer>{
	
	

}
