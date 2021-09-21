package com.hackerrank.market.service;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MarketUserDetailService implements   UserDetailsService {   // Este servicio Implementa esta interfaz de Sprint Security llamada UserDetailsService
	
    ///La idea es que esto valla a un Repositorio y se conecte a una base de datos.. pero aqui lo colocamos por defecto
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException { //Este metodo lo unico que hace es retornar un nuevo Usuario quemado en el codigo... 
		return new User("juan","{noop}pass123", new ArrayList<>());    //Este ArrayList sera el tipo de Rol por que spring security tambien maneja esto, pero aqui no se implemento ninguno... 
		                                                               //Entre la contrase;a se pone {noop} ya que esta no se paso por filtros, codificadores o encoders 
	}

}
