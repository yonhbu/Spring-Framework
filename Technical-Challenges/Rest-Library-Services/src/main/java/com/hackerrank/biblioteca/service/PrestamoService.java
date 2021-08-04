package com.hackerrank.biblioteca.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackerrank.biblioteca.exception.ClienteNoEncontrado;
import com.hackerrank.biblioteca.exception.IsbnNoExiste;
import com.hackerrank.biblioteca.exception.NoStockDisponibles;
import com.hackerrank.biblioteca.exception.UsuarioNoPuedePrestarLibro;
import com.hackerrank.biblioteca.exception.ValidarTipoUsuarioValido;
import com.hackerrank.biblioteca.model.Libro;
import com.hackerrank.biblioteca.model.Prestamo;
import com.hackerrank.biblioteca.model.Usuario;
import com.hackerrank.biblioteca.repository.IPrestamoRepository;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class PrestamoService implements IPrestamoService{

	@Autowired
	IPrestamoRepository iPrestamoRepository;

	@Autowired
	LibroService libroService;

	@Autowired
	UsuarioService usuarioService;

	@Override
	public List<Prestamo> buscar_Prestamo() {
		return (List<Prestamo>) iPrestamoRepository.findAll();
	}

	@Override
	public Prestamo prestar_Libro(Prestamo prestamo) {

		log.info("********* Prestamo de Libro ******");

		List<Libro> listadeLibros = libroService.buscar_Libro();
		List<Usuario> listadeUsuarios = usuarioService.buscar_Usuario();

		boolean validacionUsuario = validarTipoUsuarioySiyaTieneAlgunPrestamo(prestamo);
		
		if (comprobarTipoUsuarioValido(prestamo)) {

		if (!validacionUsuario) {

			for (Libro libro : listadeLibros) {
				if (libro.getIsbn().equals(prestamo.getIsbn())) {
					if (libro.getEjemplares() > 0) {
						prestamo.setLibro(libro);
					} else {
						throw new NoStockDisponibles();
					}

				} else {
					throw new IsbnNoExiste();
				}

				for (Usuario usuario : listadeUsuarios) {
					if (usuario.getIdentificacionBiblioteca().equalsIgnoreCase(prestamo.getIdentificacionUsuarioBiblioteca())) {
						prestamo.setUsuario(usuario);
					}
				}

				if (prestamo.getUsuario() == null) {
					throw new ClienteNoEncontrado();
				}
				prestamo.getLibro().setEjemplares(prestamo.getLibro().getEjemplares() - 1);
				iPrestamoRepository.save(prestamo);
				return prestamo;

			}

		}
		
		throw new UsuarioNoPuedePrestarLibro();
		
		}
		
		throw new ValidarTipoUsuarioValido();

	
	}


	public boolean validarTipoUsuarioySiyaTieneAlgunPrestamo (Prestamo prestamoNuevo) {


		List<Prestamo> listaPrestamosActuales = buscar_Prestamo();

		for (Prestamo prestamo : listaPrestamosActuales) {
			if ((prestamo.getIdentificacionUsuarioBiblioteca().equals(prestamoNuevo.getIdentificacionUsuarioBiblioteca())) && (prestamo.getUsuario().getTipoDeUsuario() == 3)) {
				return true;
			}
		}return false;



	}


	public boolean comprobarTipoUsuarioValido (Prestamo prestamoNuevo) {

			if (prestamoNuevo.getTipoUsuario() == 1) {
				return true;
			}else if (prestamoNuevo.getTipoUsuario() == 2) {
				return true;
			}else if (prestamoNuevo.getTipoUsuario() == 3) {
				return true;
			}
		return false;

	}

	@Override
	public Prestamo getConsulPrestamoById(Long id) {
		return iPrestamoRepository.findPrestamoById(id); 
	}

}