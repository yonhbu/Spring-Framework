package com.hackerrank.biblioteca.service;




import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

		boolean validacionUsuario = validarTipoUsuarioySiyaTieneAlgunPrestamo(prestamo);
		
		if (!validacionUsuario && comprobarTipoUsuarioValido(prestamo) == 1 || comprobarTipoUsuarioValido(prestamo) == 2 || comprobarTipoUsuarioValido(prestamo) == 3) {

			if (!validacionUsuario) {
				
				int tipo = prestamo.getTipoUsuario();

				switch (tipo) {
				case 1:
					return getConsultUsuarioUno(prestamo);
				case 2:
					return getConsultUsuarioDos(prestamo);
				case 3:
					return getConsultUsuarioTres(prestamo);
				default:
				}
				throw new ClienteNoEncontrado();
				
			} else {
				
				throw new UsuarioNoPuedePrestarLibro();
			}
			
			
			}
		throw new ValidarTipoUsuarioValido();
		
		

	}


	public boolean validarTipoUsuarioySiyaTieneAlgunPrestamo (Prestamo prestamoNuevo) {

		List<Prestamo> listaPrestamosActuales = buscar_Prestamo();

		for (Prestamo prestamo : listaPrestamosActuales) {
			if ((prestamo.getIdentificacionUsuario().equals(prestamoNuevo.getIdentificacionUsuario())) && (prestamo.getUsuario().getTipoDeUsuario() == 3)) {
				return true;
			}
		}return false;


	}


	public int comprobarTipoUsuarioValido (Prestamo prestamoNuevo) {	
		int tipo = prestamoNuevo.getTipoUsuario();

		int result;
		switch (tipo) {
		case 1:
			result = 1; 
			break;
		case 2:
			result = 2;
			break;
		case 3:
			result = 3;
			break;
		default:
			result = 0;
			break;
		}
		return result;

	}

	@Override
	public Prestamo getConsulPrestamoById(Long id) {
		return iPrestamoRepository.findPrestamoById(id); 
	}


	public Prestamo getConsultUsuarioTres (Prestamo prestamo) {

		log.info("********* Prestamo de Libro Usuario Tipo Invitado 3 ******");

		List<Libro> listadeLibros = libroService.buscar_Libro();
		List<Usuario> listadeUsuarios = usuarioService.buscar_Usuario();

		boolean validacionUsuario = validarTipoUsuarioySiyaTieneAlgunPrestamo(prestamo);

		if (!validacionUsuario) {

			for (Libro libro : listadeLibros) {
				if (libro.getIsbn().equals(prestamo.getIsbn())) {
					if (libro.getEjemplares() > 0) {
						LocalDate fechaPrestamo = LocalDate.now();
						fechaPrestamo = addDaysSkippingWeekends(fechaPrestamo, 7);
						String sDate2 = fechaPrestamo.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
						prestamo.setFechaMaximaDevolucion(sDate2);
						prestamo.setLibro(libro);
			
					} else {
						throw new NoStockDisponibles();
					}

				} else {
					throw new IsbnNoExiste();
				}

				for (Usuario usuario : listadeUsuarios) {
					if (usuario.getIdentificacionUsuario().equalsIgnoreCase(prestamo.getIdentificacionUsuario())) {
						prestamo.setUsuario(usuario);
						
					}
					
				}

				if (prestamo.getUsuario() == null) {
					throw new ClienteNoEncontrado();
				}
				else {
				prestamo.getLibro().setEjemplares(prestamo.getLibro().getEjemplares() - 1);

				iPrestamoRepository.save(prestamo);
				return prestamo;

				}

			}

		}
		return prestamo;

	}

	
	public Prestamo getConsultUsuarioDos (Prestamo prestamo) {

		log.info("********* Prestamo de Libro Usuario Tipo Empleado 2 ******");

		List<Libro> listadeLibros = libroService.buscar_Libro();
		List<Usuario> listadeUsuarios = usuarioService.buscar_Usuario();

		boolean validacionUsuario = validarTipoUsuarioySiyaTieneAlgunPrestamo(prestamo);

		if (!validacionUsuario) {

			for (Libro libro : listadeLibros) {
				if (libro.getIsbn().equals(prestamo.getIsbn())) {
					if (libro.getEjemplares() > 0) {
						LocalDate fechaPrestamo = LocalDate.now();
						fechaPrestamo = addDaysSkippingWeekends(fechaPrestamo, 8);
						String sDate2 = fechaPrestamo.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
						prestamo.setFechaMaximaDevolucion(sDate2);
						prestamo.setLibro(libro);
					} else {
						throw new NoStockDisponibles();
					}

				} else {
					throw new IsbnNoExiste();
				}

				for (Usuario usuario : listadeUsuarios) {
					if (usuario.getIdentificacionUsuario().equalsIgnoreCase(prestamo.getIdentificacionUsuario())) {
						prestamo.setUsuario(usuario);
						
					}
				}

				if (prestamo.getUsuario() == null) {
					throw new ClienteNoEncontrado();
				}
				else {
				prestamo.getLibro().setEjemplares(prestamo.getLibro().getEjemplares() - 1);

				iPrestamoRepository.save(prestamo);
				return prestamo;

				}

			}

		}
		return prestamo;

	}
	
	
	public Prestamo getConsultUsuarioUno (Prestamo prestamo) {

		log.info("********* Se inicia el proceso para prestarLibro Usuario Tipo Afiliado 1 ******");

		List<Libro> listadeLibros = libroService.buscar_Libro();
		List<Usuario> listadeUsuarios = usuarioService.buscar_Usuario();

		boolean validacionUsuario = validarTipoUsuarioySiyaTieneAlgunPrestamo(prestamo);

		if (!validacionUsuario) {

			for (Libro libro : listadeLibros) {
					if (libro.getEjemplares() > 0) {
						LocalDate fechaPrestamo = LocalDate.now();
						fechaPrestamo = addDaysSkippingWeekends(fechaPrestamo, 10);
						String sDate2 = fechaPrestamo.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
						prestamo.setFechaMaximaDevolucion(sDate2);
						prestamo.setLibro(libro);
					} else {
						throw new NoStockDisponibles();
					}


				for (Usuario usuario : listadeUsuarios) {
					if (usuario.getIdentificacionUsuario().equalsIgnoreCase(prestamo.getIdentificacionUsuario())) {
						prestamo.setUsuario(usuario);
						
					}
				}

				if (prestamo.getUsuario() == null) {
					throw new ClienteNoEncontrado();
				}
				else {
				prestamo.getLibro().setEjemplares(prestamo.getLibro().getEjemplares() - 1);
				iPrestamoRepository.save(prestamo);
				log.info("********* Prestamo Realizado - HECHO AFILIADO 1 ******");
				return prestamo;

				}

			}

		}
		return prestamo;

	}
	
	
	public LocalDate addDaysSkippingWeekends(LocalDate date, int days) {
		LocalDate result = date;
		int addedDays = 0;
		while (addedDays < days) {
			result = result.plusDays(1);
			if (!(result.getDayOfWeek() == DayOfWeek.SATURDAY || result.getDayOfWeek() == DayOfWeek.SUNDAY)) {
				++addedDays;
			}
		}
		return result;
	}

}
