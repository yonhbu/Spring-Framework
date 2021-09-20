package com.practice.model.libreria;




import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name="LIBRERIA")
public class Libreria {

	@Id()
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "id_libro")
	private Integer idLibro;

	private String isbn;

	@JoinTable(
			name = "FK_rel_libros_titulos",
			joinColumns = @JoinColumn(name = "FK_BOOK", nullable = false),
			inverseJoinColumns = @JoinColumn(name="FK_TITULO", nullable = false)
			)
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Titulo> titulo;


	@JoinTable(
			name = "FK_rel_libros_autor",
			joinColumns = @JoinColumn(name = "FK_BOOK", nullable = false),
			inverseJoinColumns = @JoinColumn(name="FK_AUTOR", nullable = false)
			)
	@ManyToMany(cascade = CascadeType.ALL)
	@JsonIgnoreProperties(value="libreria")
	private List<Autor> autor;



}
