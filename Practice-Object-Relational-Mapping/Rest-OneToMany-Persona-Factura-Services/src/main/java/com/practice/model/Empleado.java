package com.practice.model;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(name="EMPLEADO")
public class Empleado {
	
	@Id()
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column (name = "id_empleado")
	private Integer idEmpleado;
	
	private String nombre;
	
	private int edad;
	
	//RELACION UNO A  UNO BIDIRECCIONAL
//	@OneToOne (cascade = CascadeType.ALL)
//	@JoinColumn(name = "FK_id_direccion")
//	private Direccion direccion;
	
	
	//RELACION UNO A  MUCHOS BIDIRECCIONAL
	@OneToMany (cascade = CascadeType.ALL)
	@JoinColumn(name = "FK_id_direccion", referencedColumnName = "id_empleado")
	private List<Direccion> direccion;
	


}
