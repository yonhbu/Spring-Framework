package co.com.event.jpa;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;


@Repository
public interface EventRepositoryJPA extends CrudRepository<EventDataJPA, Integer>, QueryByExampleExecutor<EventDataJPA> {
	
	@Query("SELECT e FROM EventDataJPA e WHERE e.id = id")
	EventDataJPA findEventDataJPAById(Integer id);
	
	@Query("SELECT e FROM EventDataJPA e WHERE e.repoId = repoId")
	List<EventDataJPA> findEventDataJPAByRepoId(Integer id);
	
	@Query("SELECT e FROM EventDataJPA e WHERE e.actorId = actorId")
	List<EventDataJPA> findEventDataJPAByUserId(Integer id);
	
	@Query("SELECT e FROM EventDataJPA e WHERE e.isPublic = :ispublic")
	List<EventDataJPA> findEventDataJPAByisPublic(@Param("ispublic") final Boolean ispublic);
	



	
}
