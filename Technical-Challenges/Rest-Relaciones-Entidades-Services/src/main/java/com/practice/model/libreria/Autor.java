package com.practice.model.libreria;




import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="AUTOR")
public class Autor {
	
	@Id()
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "id_autor")
	private Integer idAutor;
	
	private String nombre;
	private String apellido;

	@ManyToMany(mappedBy = "autor")
	@JsonIgnoreProperties(value="autor")
	private List<Libreria> libreria;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JsonIgnoreProperties(value="autor")
	private Contacto contacto;
	
	


	

}
