package co.com.practical.model;

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
@Table(name="Personaje")
public class Personaje {
	
	@Id()
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "idPersonaje")
	private Long id;
	
	@Column (name = "Nombre")
	private String nombre;
	
	@Column (name = "Edad")
	private int edad;
	
	@Column (name = "Peso")
	private int peso;
	
	@Column (name = "Historia")
	private String historia;
	
	@Column (name = "Pelicula")
	private Pelicula pelicula;

}
