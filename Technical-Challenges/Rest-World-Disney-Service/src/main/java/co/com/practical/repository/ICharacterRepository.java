package co.com.practical.repository;

import org.springframework.data.repository.CrudRepository;

import co.com.practical.model.Genres;

public interface ICharacterRepository extends CrudRepository<Long, Genres>{
	
	

}
