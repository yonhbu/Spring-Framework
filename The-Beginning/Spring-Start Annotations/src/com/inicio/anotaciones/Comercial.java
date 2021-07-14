package com.inicio.anotaciones;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


@Component
public class Comercial implements Empleado {
	
	
	@Autowired
	@Qualifier("informeTrim2")
	private CreacionInformeFinanciero nuevoInforme;
	

	public void setNuevoInforme(CreacionInformeFinanciero nuevoInforme) {
		this.nuevoInforme = nuevoInforme;
	}




	@Override
	public String getTareas() {
		return "Vender Vender y Vender Mas";
	}

	@Override
	public String getInforme() {	
		return nuevoInforme.getInforme();
	}
	
	
}