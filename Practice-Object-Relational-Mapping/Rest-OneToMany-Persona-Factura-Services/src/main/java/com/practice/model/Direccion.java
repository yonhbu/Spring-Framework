package com.practice.model;




import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="DIRECCION")
public class Direccion {
	
	@Id()
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "id_direccion")
	private Integer idDireccion;
	
	private String numero;
	private String ciudad;
	
	 
	//@OneToOne (cascade = CascadeType.ALL)
	//@JsonIgnoreProperties(value="direccion")
	@OneToMany(mappedBy = "direccion")
	private List<Empleado> empleado;



}
