package com.hackerrank.market.service;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackerrank.market.model.Usuario;
import com.hackerrank.market.repository.IUsuarioRepository;





@Service
public class UsuarioService implements IUsuarioService{
	
	@Autowired
	IUsuarioRepository iUsuarioRepository;

	@Override
	public Usuario crear_Usuario(Usuario usuario) {		
		return iUsuarioRepository.save(usuario);
	}

	@Override
	public List<Usuario> buscar_Usuario() {
		return (List<Usuario>) iUsuarioRepository.findAll();
	}

	
}