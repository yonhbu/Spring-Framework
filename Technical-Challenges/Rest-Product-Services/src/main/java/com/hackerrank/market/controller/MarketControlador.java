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

import com.hackerrank.market.dto.dataRQ.RequestCategoriaDTO;
import com.hackerrank.market.dto.dataRQ.RequestClienteDTO;
import com.hackerrank.market.dto.dataRQ.RequestCompraDTO;
import com.hackerrank.market.dto.dataRQ.RequestProductoDTO;
import com.hackerrank.market.dto.dataRS.ResponseCategoriaDTO;
import com.hackerrank.market.dto.dataRS.ResponseClienteDTO;
import com.hackerrank.market.dto.dataRS.ResponseCompraDTO;
import com.hackerrank.market.dto.dataRS.ResponseProductoDTO;
import com.hackerrank.market.model.Categoria;
import com.hackerrank.market.model.Cliente;
import com.hackerrank.market.model.Compra;
import com.hackerrank.market.model.Producto;
import com.hackerrank.market.service.CategoriaService;
import com.hackerrank.market.service.ClienteService;
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
	private ClienteService clienteService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	@GetMapping("/allProduct")
    @ResponseStatus(HttpStatus.OK)
	public List<Producto> getAll () {
		return productoService.getAll();
	}
	
   
    
	@PostMapping("/product")
	public ResponseEntity<ResponseProductoDTO> saveProducts(@RequestBody RequestProductoDTO productoDTO) {
		
		// convert DTO to entity
		Producto productoRequest = modelMapper.map(productoDTO, Producto.class);
		Producto producto =	productoService.crear_Producto(productoRequest);

		// convert entity to DTO
		ResponseProductoDTO productoResponse = modelMapper.map(producto, ResponseProductoDTO.class);
		return new ResponseEntity<>(productoResponse, HttpStatus.OK);
		
	}
	
	
	@GetMapping("/product/{productoId}")
	public ResponseEntity<Producto> getProductoById (@PathVariable("productoId") int productoId) {
		
		return productoService.getProducto(productoId)
				.map(produc -> new ResponseEntity<> (produc, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
		
	}
	
	
	 @DeleteMapping("/product/delete/{id}")
	    public ResponseEntity<String> delete (@PathVariable("id") int productId) {
	    	
	    	if (productoService.deleteProducto(productId)) {
	    		return new ResponseEntity<>("Producto Eliminado Exitosamente", HttpStatus.OK);
	    	} else {
	    		return new ResponseEntity<>("Producto No Encontrado",HttpStatus.NOT_FOUND);
	    	}
	    	
	    }
	
	
	@PostMapping("/category")
	public ResponseEntity<ResponseCategoriaDTO> saveCategoria(@RequestBody RequestCategoriaDTO categoriaDTO) {

		// convert DTO to entity
		Categoria categoriaRequest = modelMapper.map(categoriaDTO, Categoria.class);
		Categoria categoria = categoriaService.crear_Categoria(categoriaRequest);

		// convert entity to DTO
		ResponseCategoriaDTO categoriaResponse = modelMapper.map(categoria, ResponseCategoriaDTO.class);
		return new ResponseEntity<>(categoriaResponse, HttpStatus.OK);
		
		
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
    
    
    
    @PostMapping("/cliente")
	public ResponseEntity<ResponseClienteDTO> saveCliente (@RequestBody RequestClienteDTO requestClienteDTO) {

		// convert DTO to entity
		Cliente clienteRequest = modelMapper.map(requestClienteDTO, Cliente.class);
		Cliente cliente = clienteService.crear_Cliente(clienteRequest);

		// convert entity to DTO
		ResponseClienteDTO clienteResponse = modelMapper.map(cliente, ResponseClienteDTO.class);
		return new ResponseEntity<>(clienteResponse, HttpStatus.OK);
		
		
		
	}
    
    
    @GetMapping("/allClientes")
    @ResponseStatus(HttpStatus.OK)
	public List<ResponseClienteDTO> getAllCliente () {
		return clienteService.getAll();
	}
    
    
    
	@GetMapping("/cliente/{clienteId}")
	public ResponseEntity<List<Compra>> getCompraById (@PathVariable("clienteId") String clienteId) {
		return compraService.getByClient(clienteId)
				.map(compra -> new ResponseEntity<>(compra, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
		
	}

    
	@PostMapping("/compra")
	public ResponseEntity<ResponseCompraDTO> saveCompra (@RequestBody RequestCompraDTO requestCompraDTO) {

		// convert DTO to entity
		Compra compraRequest = modelMapper.map(requestCompraDTO, Compra.class);
		Compra compra = compraService.crear_Compra(compraRequest);

		// convert entity to DTO
		ResponseCompraDTO compraResponse = modelMapper.map(compra, ResponseCompraDTO.class);
		return new ResponseEntity<>(compraResponse, HttpStatus.OK);
		
		
		
	}
	
    
    @GetMapping("/allCompras")
    @ResponseStatus(HttpStatus.OK)
	public List<Compra> getAllCompras () {
		return compraService.getAll();
	}
	
	
    
    


}

