package com.inicio.anotaciones;

import org.springframework.stereotype.Component;

@Component
public class InformeTrim1 implements CreacionInformeFinanciero {

	@Override
	public String getInforme() {
		
		return "El informe de ventas del primer trimestre es de 50 mil pesos";
	}

}
