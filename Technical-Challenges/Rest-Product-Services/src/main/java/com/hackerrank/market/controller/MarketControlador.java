package com.hackerrank.market.controller;


import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hackerrank.market.dto.CategoriaDTO;
import com.hackerrank.market.dto.ProductoDTO;
import com.hackerrank.market.model.Categoria;
import com.hackerrank.market.model.Producto;
import com.hackerrank.market.service.CategoriaService;
import com.hackerrank.market.service.ProductoService;




@RestController
@RequestMapping("/market")
public class MarketControlador {

	@Autowired
	private ProductoService productoService;
	
	@Autowired
	private CategoriaService categoriaService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
	public List<Producto> getAll () {
		return productoService.getAll();
	}
	
   
    
	@PostMapping("/product")
	public ResponseEntity<Void> saveProducts(@RequestBody ProductoDTO productoDTO) {
		productoService.crear_Producto(modelMapper.map(productoDTO, Producto.class));
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	
	@PostMapping("/category")
	public ResponseEntity<Void> saveCategoria(@RequestBody CategoriaDTO categoriaDTO) {
		categoriaService.crear_Categoria(modelMapper.map(categoriaDTO, Categoria.class));
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}


}

