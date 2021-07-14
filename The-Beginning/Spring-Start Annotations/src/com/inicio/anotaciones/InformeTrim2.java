package com.inicio.anotaciones;


import org.springframework.stereotype.Component;

@Component
public class InformeTrim2 implements CreacionInformeFinanciero {

	@Override
	public String getInforme() {
		return "Informe de Venta de todo el Año 1 millon de pesos";
	}

}
