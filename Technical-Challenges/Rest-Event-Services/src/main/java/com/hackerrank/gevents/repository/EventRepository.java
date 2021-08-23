package com.hackerrank.gevents.repository;

import com.hackerrank.gevents.model.Event;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event, Integer> {
	
	Optional<Event> findById(Integer id);
	
	@Query("SELECT e FROM Event e WHERE e.repoId = repoId")
	List<Event> findEventsByRepoId(Integer id);
	
	@Query("SELECT e FROM Event e WHERE e.actorId = actorId")
	List<Event> findEventsByUserId(Integer id);
	
}
