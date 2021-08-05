package com.practical.disney.model;

import java.util.List;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

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
public class Personaje  {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "idPersonaje")
	@Id	
	private Long idpersonaje;
	
//	private String imagen;
	
	private String nombre;
	
	private Integer edad;
	
	private Integer peso;
	
	private String historia;
	
	 @JsonManagedReference
     @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
     @JoinTable(name = "personajes_peliculas",
     joinColumns = {
             @JoinColumn(name = "idpersonaje", nullable = false)},
     inverseJoinColumns = {
             @JoinColumn(name = "idpelicula", nullable = false)})
	 private List<Pelicula> peliculaID;
      
     
}
