package com.hackerrank.market.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationRequest {
	
	//Aqui seria cuando el usuario se loguea

	private String user;
	private String pass;

}

