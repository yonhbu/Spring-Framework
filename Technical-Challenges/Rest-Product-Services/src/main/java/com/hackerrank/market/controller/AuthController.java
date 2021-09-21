package com.hackerrank.market.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hackerrank.market.dto.AuthenticationRequest;
import com.hackerrank.market.dto.AuthenticationResponse;
import com.hackerrank.market.security.JWTUtil;
import com.hackerrank.market.service.MarketUserDetailService;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
	@Autowired
	private AuthenticationManager authenticationManager;  //Gestor de Autenticacion de Spring
	
	@Autowired
	private MarketUserDetailService marketUserDetailService;
	
	
	@Autowired
	private JWTUtil jWTUtil;
	
	
	@PostMapping("/authenticate")  //Este metodo sera el encargado de generar o responder un Token cuando alguien inicio session
	public ResponseEntity<AuthenticationResponse> createToken (@RequestBody AuthenticationRequest authenticationRequest ) {//Recibira los datos del usuario a loguearse 
	
		try {
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUser(), authenticationRequest.getPass())); //La comprobacion se hara por usuario y contrase;a
		UserDetails userDetails = marketUserDetailService.loadUserByUsername(authenticationRequest.getUser()); // Obtenemos los detalles del usuario desde el servicio que creamos para este Fin
		String jwt = jWTUtil.generateToken(userDetails); //Creamos el token con los datos del usuario y el metodo anteriormente creado
		return new ResponseEntity<AuthenticationResponse> (new AuthenticationResponse(jwt), HttpStatus.OK);
		
	}catch (BadCredentialsException e) { //Este error ocurre cuando no ocurra la autenticacion, cuando no sea juan o la contrase;a la correcta
		return new ResponseEntity<AuthenticationResponse>(HttpStatus.FORBIDDEN);
	}
		
	}
	

}
