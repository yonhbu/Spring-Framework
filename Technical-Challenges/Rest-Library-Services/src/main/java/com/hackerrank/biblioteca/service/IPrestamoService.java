package com.hackerrank.biblioteca.service;



import java.util.List;

import com.hackerrank.biblioteca.model.Prestamo;


public interface IPrestamoService {
	
	public List<Prestamo> buscar_Prestamo ();
	
	public Prestamo prestar_Libro (Prestamo prestamo);
	
	public Prestamo getConsulPrestamoById (Long id);
	
}
