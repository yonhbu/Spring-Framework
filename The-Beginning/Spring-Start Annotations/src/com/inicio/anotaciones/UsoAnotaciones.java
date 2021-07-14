package com.inicio.anotaciones;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UsoAnotaciones {

	public static void main(String[] args) {

		//Leer el XML el configuration
		//ClassPathXmlApplicationContext contexto = new ClassPathXmlApplicationContext("beans.xml");
		AnnotationConfigApplicationContext contexto = new AnnotationConfigApplicationContext(XML_BeanConfig.class);

		//Pedir el Bean
		Empleado juan = contexto.getBean("comercial", Comercial.class);
		System.out.println(juan.getTareas());
		System.out.println(juan.getInforme());
		
		//Cerrar el flujo
		contexto.close();
	}

}
