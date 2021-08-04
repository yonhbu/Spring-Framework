package com.ceiba.biblioteca.service;



import java.util.List;

import com.ceiba.biblioteca.dto.PrestamoRequestDTO;
import com.ceiba.biblioteca.model.Prestamo;

public interface IPrestamoService {
	
	public List<Prestamo> buscar_Prestamo ();
	
	public Prestamo prestar_Libro (Prestamo prestamo);
	
	public Prestamo getConsulPrestamoById (Long id);
	
}
