package com.hackerrank.market.controller;


import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hackerrank.market.dto.RequestCategoriaDTO;
import com.hackerrank.market.dto.RequestCompraDTO;
import com.hackerrank.market.dto.RequestProductoDTO;
import com.hackerrank.market.model.Categoria;
import com.hackerrank.market.model.Compra;
import com.hackerrank.market.model.Producto;
import com.hackerrank.market.service.CategoriaService;
import com.hackerrank.market.service.CompraService;
import com.hackerrank.market.service.ProductoService;




@RestController
@RequestMapping("/market")
public class MarketControlador {

	@Autowired
	private ProductoService productoService;
	
	@Autowired
	private CategoriaService categoriaService;
	
	@Autowired
	private CompraService compraService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	@GetMapping("/allProduct")
    @ResponseStatus(HttpStatus.OK)
	public List<Producto> getAll () {
		return productoService.getAll();
	}
	
   
    
	@PostMapping("/product")
	public ResponseEntity<Void> saveProducts(@RequestBody RequestProductoDTO productoDTO) {
		productoService.crear_Producto(modelMapper.map(productoDTO, Producto.class));
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	
	@GetMapping("/product/{productoId}")
	public ResponseEntity<Producto> getProductoById (@PathVariable("productoId") int productoId) {
		
		return productoService.getProducto(productoId)
				.map(produc -> new ResponseEntity<> (produc, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
		
	}
	
	
	 @DeleteMapping("/product/delete/{id}")
	    public ResponseEntity<?> delete (@PathVariable("id") int productId) {
	    	
	    	if (productoService.deleteProducto(productId)) {
	    		return new ResponseEntity<>(HttpStatus.OK);
	    	} else {
	    		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    	}
	    	
	    }
	
	
	@PostMapping("/category")
	public ResponseEntity<Void> saveCategoria(@RequestBody RequestCategoriaDTO categoriaDTO) {
		categoriaService.crear_Categoria(modelMapper.map(categoriaDTO, Categoria.class));
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	
	@GetMapping("/category/{categoryId}")
	public ResponseEntity<List<Producto>> getCategoryById (@PathVariable("categoryId") int categoryId) {
		return productoService.getByCategoria(categoryId)
				.map(product -> new ResponseEntity<>(product, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
		
	}
	
    @GetMapping("/allCategory")
    @ResponseStatus(HttpStatus.OK)
	public List<Categoria> getAllCategory () {
		return categoriaService.getAll();
	}
    
    
    
	@PostMapping("/compra")
	public ResponseEntity<Void> saveCompra (@RequestBody Compra requestCompraDTO) {
		compraService.crear_Compra(requestCompraDTO);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	
    
    @GetMapping("/allCompras")
    @ResponseStatus(HttpStatus.OK)
	public List<Compra> getAllCompras () {
		return compraService.getAll();
	}
	
	
    
    


}

