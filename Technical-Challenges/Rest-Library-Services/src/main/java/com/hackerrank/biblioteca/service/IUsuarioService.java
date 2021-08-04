package com.hackerrank.biblioteca.service;

import java.util.List;

import com.hackerrank.biblioteca.model.Usuario;

public interface IUsuarioService {
	
	public Usuario crear_Usuario (Usuario usuario);
	
	public List<Usuario> buscar_Usuario ();
	

}
