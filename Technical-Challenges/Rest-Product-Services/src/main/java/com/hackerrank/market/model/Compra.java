package com.hackerrank.market.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
	@Column (name = "id_compra")
	private Integer idCompra;
	
	@Column (name = "id_cliente")
	private String idCliente;
	
	private LocalDateTime fecha;
	
	@Column (name = "medio_pago")
	private String medioPago;
	
	private String comentario;
	
	private String estado; //Si la orden ya se pago o no
	
	@ManyToOne
	@JoinColumn(name = "id_cliente", insertable = false, updatable = false)
	private Cliente cliente;
	
	@OneToMany(mappedBy = "producto", cascade = {CascadeType.ALL})
	private List<ComprasProducto> productos;
	



}
