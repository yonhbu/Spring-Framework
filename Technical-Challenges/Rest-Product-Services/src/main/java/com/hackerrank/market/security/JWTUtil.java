package com.hackerrank.market.security;

import java.util.Date;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JWTUtil {
	
	private static String KEY = "market";
	
	
	//  El token lleva por dentro, el tipo de token, el usuario, la fecha en que vence, y con que algoritmo esta firmado
	//  Por lo que se le agrega a ese token los datos o credenciales del usuario logueado con userDetails + la fecha en que fue creado con setIssuedAt
	
	public String generateToken (UserDetails userDetails ) { //Este metodo nos permite generar un token con una duracion de 10 horas y recibe los userDetails del usuario autenticado
		return Jwts.builder().setSubject(userDetails.getUsername()).setIssuedAt(new Date()) //Jwts Es de IO WEB TOKEN, la dependencia que incluimos y con un builder construimos el JWT
				.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
				.signWith(SignatureAlgorithm.HS256, KEY).compact(); // El tipo de algoritmo que sera firmado y necesitamos una clave que debe ser bien robusta
				
	}
	
	
	//Este metodo auxiliar obtenemos los Claims que son los objetos que tiene un token dentro.. recordemos por como esta conformado un token
	public Claims getClaims (String token) { //Recibe el token
		return Jwts.parser().setSigningKey(KEY).parseClaimsJws(token).getBody(); // Con Jwts Que es una clase de IO WEB TOKEN hacemos esto, le a;ado la clave de la firma
	}
	
	
	//Seguido extramos el usuario del token
	public String extractUsername (String token) {
		return getClaims(token).getSubject(); //Recordemos que en los SubJect estan los datos del usuario en el token
		
	}
	
	
	public boolean isTokenExpirate (String token) {
		return getClaims(token).getExpiration().before(new Date()); //Usamos el metodo anterior getClaims donde le pasamos el token y con getExpiration validamos que la fecha de creacion esta antes osea before de la creacion
	}
	
	
	//Valida si el Token es Correcto y para ello necesitamos saber que ese token de verdad este creado para ese usuario que esta haciendo la peticion y que no haya expirado
	public boolean validateToken (String token, UserDetails userDetails) { //Recibe el token y los userDetails de cada peticion
		return userDetails.getUsername().equals(extractUsername(token)) && !isTokenExpirate(token); //Si el usuario que esta llegando en la peticiones igual al que esta en el token y preguntamos que no haya expirado el token
	}
	

	
	

}
