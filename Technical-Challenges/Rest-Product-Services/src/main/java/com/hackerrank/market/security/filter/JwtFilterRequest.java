package com.hackerrank.market.security.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.hackerrank.market.security.JWTUtil;
import com.hackerrank.market.service.MarketUserDetailService;


//Esta clase se encarga de atrapar todas las peticiones que recibe mi aplicacion y verifique si el token es correcto
@Component
public class JwtFilterRequest extends OncePerRequestFilter { // Extendemos de OncePerRequestFilter de Spring security para que este filtro o clase se ejecute cada que haya una peticion
	
	
	@Autowired
	private JWTUtil jwtUtil;
	
	@Autowired
	private MarketUserDetailService marketUserDetailService;
	

	//Aqui verifico que si lo que viene en el encabezado o el header es un token y que si es correcto
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		String authorizationHeader = request.getHeader("Authorization"); //Capturamos el header que nos llega
		
		if (authorizationHeader != null && authorizationHeader.startsWith("Bearer") ) {//Pregunto si si viene y si comienza con el prefijo Bearer, si todo es correcto pasa
			
			String jwt = authorizationHeader.substring(7); //Aqui eliminamos el Bearer y obtenemos lo que es todo el token, desde el caracter 7 viene ese JWT
			
			String userName = jwtUtil.extractUsername(jwt); // Aqui extraigo el usuario usando los metodos que cree anteriormente extractUsername el cual recibe un token
			
			if (userName != null && SecurityContextHolder.getContext().getAuthentication() == null ) {   //Esto se realizada para comprobar que en el contexto no exista ninguna autenticacion ya para ese usuario
				
				UserDetails userDetails = marketUserDetailService.loadUserByUsername(userName); //Obtenemos los userDetails inyectando el servicio que tiene los datos 
				
				if (jwtUtil.validateToken(jwt, userDetails)) { //Preguntamos si el token es correcto, si si pasa hacemos lo siguiente
					
                    //Usamos esta clase UsernamePasswordAuthenticationToken y le pasamos los datos o roles
					UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken (userDetails, null, userDetails.getAuthorities());
					authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));// Aqui le pasamos los detalles de la conexion que se esta realizando, con el fin de evaluar que navegador uso, SO hora etc.
					
					SecurityContextHolder.getContext().setAuthentication(authToken); //Asignamos la autenticacion para que la proxima vez no pase por todo lo anterior 
					
				}
				
			}
			
		}
		
		filterChain.doFilter(request, response); //y ya por ultimo usamos el filtro
		
	}

}
