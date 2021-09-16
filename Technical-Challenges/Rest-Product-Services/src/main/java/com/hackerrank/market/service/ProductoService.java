package com.hackerrank.market.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hackerrank.market.model.Producto;
import com.hackerrank.market.repository.IProductoRepository;


@Service
public class ProductoService implements IProductoService{
	
	@Autowired
	IProductoRepository iUsuarioRepository;

	@Override
	public Producto crear_Producto(Producto producto) {
		return iUsuarioRepository.save(producto);
	}

	@Override
	public List<Producto> getAll() {
		return (List<Producto>) iUsuarioRepository.findAll();
	}

	@Override
	public Optional<List<Producto>> getByCategoria(int categoriaProducto) {
		return iUsuarioRepository.findByCategoriaProducto(categoriaProducto);
	}

	@Override
	public List<Producto> getByCategoriaOrderByName(int categoriaProducto) {
		return iUsuarioRepository.findByCategoriaProductoOrderByNombreAsc(categoriaProducto);
	}

	@Override
	public Optional<List<Producto>> getEscasos(int cantidad, boolean estado) {
		return iUsuarioRepository.findByCantidadStockLessThanAndEstado(cantidad, true);
	}

	@Override
	public Optional<Producto> getProducto(int idProducto) {
		return iUsuarioRepository.findById(idProducto);
	}

	@Override
	public boolean deleteProducto(int idProducto) {
		
		return getProducto(idProducto).map(producto -> {
			iUsuarioRepository.deleteById(idProducto);
			return true;
		}).orElse(false);
				
		
	}

	
}