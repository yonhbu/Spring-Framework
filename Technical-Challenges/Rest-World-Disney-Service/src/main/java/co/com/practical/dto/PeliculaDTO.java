package co.com.practical.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class PeliculaDTO {
	
	private Long id;
	private String titulo;
	private Date fechaCreacion;
	private int calificaicon;
	private PersonajeDTO personajesAsociados;

}
