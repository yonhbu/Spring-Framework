package com.practice.repository.libreria;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.practice.model.libreria.Autor;




@Repository
public interface IAutorRepository extends JpaRepository <Autor, Integer>{

	//@Query("SELECT *  FROM LIBRERIA WHERE AUTOR.NOMBRE = ?")
	public List<Autor> findByNombre (String nombre);

}
