package com.hackerrank.market.service;

import java.util.List;

import com.hackerrank.market.model.Usuario;




public interface IUsuarioService {
	
	public Usuario crear_Usuario (Usuario usuario);
	
	public List<Usuario> buscar_Usuario ();
	

}
