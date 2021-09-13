package com.hackerrank.market.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hackerrank.market.model.Producto;


@Repository
public interface IProductoRepository extends CrudRepository<Producto, Integer>{
	
	List<Producto> findByIdCategoria (int idCategoria);
	
	List<Producto> findByIdCategoriaOrderByNombreAsc (int idCategoria);
	
	Optional<List<Producto>> findByCantidadStockLessThanAndEstado (int cantidadStock, boolean estado);
	
	//or
	
	//@Query(value = "SELECT * FROM productos WHERE idCategoria = ?", nativeQuery = true)
	//List<Producto> getByIdCategoria (int idCategoria);
	

}
