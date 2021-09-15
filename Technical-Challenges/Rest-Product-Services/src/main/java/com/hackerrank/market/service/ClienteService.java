package com.hackerrank.market.service;


import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackerrank.market.dto.dataRS.ResponseClienteDTO;
import com.hackerrank.market.model.Cliente;
import com.hackerrank.market.repository.IClienteRepository;


@Service
public class ClienteService implements IClienteService{
	
	@Autowired
	IClienteRepository iClienteRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public Cliente crear_Cliente(Cliente cliente) {
		return iClienteRepository.save(cliente);
	}

	@Override
	public List<ResponseClienteDTO> getAll() {
		
		List<Cliente> listaClienteEntidad = (List<Cliente>) iClienteRepository.findAll();
		
		List<ResponseClienteDTO> listaResponseClienteDTO = new ArrayList<ResponseClienteDTO>();
		
		listaClienteEntidad.forEach( lista -> listaResponseClienteDTO.add(modelMapper.map(lista,  ResponseClienteDTO.class)));
		
		return listaResponseClienteDTO;

	}

	

	
	
}