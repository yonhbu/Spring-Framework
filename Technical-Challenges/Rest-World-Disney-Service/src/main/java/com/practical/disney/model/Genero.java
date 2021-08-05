package com.practical.disney.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
@Table(name="Genero")
public class Genero {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "idGenero")
	@Id
	private Long idgenero;

	private String nombre;
	
  //private String image;

    @JsonManagedReference
    @OneToMany(mappedBy = "genero",fetch=FetchType.LAZY, cascade = CascadeType.ALL)    
	private List<Pelicula> peliculaAsociada;

}
