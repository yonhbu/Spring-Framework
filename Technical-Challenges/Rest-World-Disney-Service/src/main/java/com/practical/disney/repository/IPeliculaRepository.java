package com.practical.disney.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.practical.disney.model.Pelicula;


@Repository
public interface IPeliculaRepository extends CrudRepository<Pelicula,Long>{
	
	@Query("SELECT p FROM Pelicula p WHERE p.titulo = :titulo")
	List<Pelicula> findPeliculaByTitulo(@Param("titulo") final String titulo);
	
	Pelicula findPeliculaByidpelicula(Long id);
	

}
