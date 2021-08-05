package com.practical.disney.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.practical.disney.model.Personaje;

@Repository
public interface IPersonajeRepository extends CrudRepository<Personaje,Long>{
	
	@Query("SELECT p FROM Personaje p WHERE p.nombre = :name")
	List<Personaje> findPersonajeByName(@Param("name") final String nombre);

	Personaje findPersonajeByIdpersonaje(Long id);

}
