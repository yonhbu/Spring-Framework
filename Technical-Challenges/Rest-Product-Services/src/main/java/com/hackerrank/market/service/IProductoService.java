package com.hackerrank.market.service;

import java.util.List;
import java.util.Optional;

import com.hackerrank.market.model.Producto;




public interface IProductoService {
	
	public Producto crear_Producto (Producto producto);
	
	public List<Producto> getAll ();
	
	public Optional<List<Producto>> getByCategoria (int categoriaProducto);
	
	public List<Producto> getByCategoriaOrderByName (int categoriaProducto);
	
	public Optional<List<Producto>> getEscasos (int cantidad, boolean estado);
	
	public Optional<Producto> getProducto (int idProducto);
	
	public boolean deleteProducto (int idProducto);

	

}
