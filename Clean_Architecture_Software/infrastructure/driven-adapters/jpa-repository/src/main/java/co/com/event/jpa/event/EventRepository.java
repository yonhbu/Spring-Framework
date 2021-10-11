package co.com.event.jpa.event;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;


@Repository
public interface EventRepository extends CrudRepository<EventData, Integer>, QueryByExampleExecutor<EventData> {
	
	@Query("SELECT e FROM EventData e WHERE e.id = id")
	EventData findEventDataById(Integer id);
	
	@Query("SELECT e FROM EventData e WHERE e.repoId = repoId")
	List<EventData> findEventDataByRepoId(Integer id);
	
	@Query("SELECT e FROM EventData e WHERE e.actorId = actorId")
	List<EventData> findEventDataByUserId(Integer id);
	
	@Query("SELECT e FROM EventData e WHERE e.isPublic = :ispublic")
	List<EventData> findEventDataByisPublic(@Param("ispublic") final Boolean ispublic);
	



	
}
