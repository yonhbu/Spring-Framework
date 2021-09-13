package com.hackerrank.market.model;

import java.time.LocalDateTime;
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
@Table(name="Compra")
public class Compra {
	
	@Id()
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "idCompra")
	private int id;
	
	private String idCliente;
	private LocalDateTime fecha;
	private char medio_de_Pago;
	private String comentario;
	private String estado;
	
	@ManyToOne
	@JoinColumn(name = "idCliente", insertable = false, updatable = false)
	private Cliente cliente;
	
	@OneToMany(mappedBy = "compra")
	private List<ComprasProducto> comprasProducto;
	

	
	
	


}
