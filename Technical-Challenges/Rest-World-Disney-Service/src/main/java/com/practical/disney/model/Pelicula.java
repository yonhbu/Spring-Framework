package com.practical.disney.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

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
public class Pelicula  {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "idPelicula")
	@Id	
	private Long idpelicula;
	
	private String titulo;
	
//	private String image;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-dd-MM")
	private LocalDate fechaCreacion;
	
	private Integer calificacion;
	
    @JsonBackReference
    @ManyToMany(fetch=FetchType.LAZY,  mappedBy = "peliculaID", cascade = CascadeType.ALL)
    private List<Personaje> personajeAsociado;


}
