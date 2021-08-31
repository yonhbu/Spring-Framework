package com.hackerrank.gevents.repository;

import com.hackerrank.gevents.model.Event;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event, Integer> {
	
	@Query("SELECT e FROM Event e WHERE e.id = id")
	Event findEventById(Integer id);
	
	@Query("SELECT e FROM Event e WHERE e.repoId = repoId")
	List<Event> findEventsByRepoId(Integer id);
	
	@Query("SELECT e FROM Event e WHERE e.actorId = actorId")
	List<Event> findEventsByUserId(Integer id);
	
	@Query("SELECT e FROM Event e WHERE e.isPublic = :ispublic")
	List<Event> findEventByisPublic(@Param("ispublic") final Boolean ispublic);

	
}
