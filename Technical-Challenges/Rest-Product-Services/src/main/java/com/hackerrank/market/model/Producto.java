package com.hackerrank.market.model;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Producto")
public class Producto {
	
	@Id()
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "id_producto")
	private Integer idProducto;
	
	private String nombre;
	
	@Column (name = "id_categoria")
	private int idCategoria;
	
	@Column (name = "codigo_barras")
	private String codigoBarras;
	
	@Column (name = "precio_venta")
	private Double precioVenta;
	
	@Column (name = "cantidad_stock")
	private Integer cantidadStock;
	
	private Boolean estado;
	
	@ManyToOne
	@JoinColumn(name ="id_categoria", insertable = false, updatable = false)
	private Categoria categoria;
	

	
	
	


}
