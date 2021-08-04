package co.com.practical.model;

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
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Pelicula")
public class Pelicula {
	
	@Id()
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "idPelicula")
	private Long id;
	
	@Column (name = "Titulo")
	private String titulo;
	
	@Column (name = "FechaCreacion")
	private Date fechaCreacion;
	
	@Column (name = "Calificacion")
	private int calificacion;
	
	@Column (name = "PersonajeAsociado")
	private Personaje personajeAsociado;

}
