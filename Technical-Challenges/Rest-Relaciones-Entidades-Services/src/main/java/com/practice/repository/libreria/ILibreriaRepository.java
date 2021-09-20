package com.practice.repository.libreria;




import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;


import com.practice.model.libreria.Libreria;



@Repository
public interface ILibreriaRepository extends JpaRepository <Libreria, Integer>{


}
