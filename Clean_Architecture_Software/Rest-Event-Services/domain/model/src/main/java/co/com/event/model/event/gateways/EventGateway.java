package co.com.event.model.event.gateways;

import java.util.List;
import java.util.Optional;

import co.com.event.model.event.Event;

public interface EventGateway {
	
    public List<Event> findEvent ();
	
	public List<Event> findEventbyRepoId (Integer id);
	
	public List<Event> findEventbyUserId (Integer id);
	
	public Optional<Event> findById(Integer id);
	
	public List<Event> findEventByisPublic(Boolean ispublic);

	public Event findEventById(Integer id);
	
	public Event createEvent (Event event);
	
	public Event updateEvent (Integer id, Event event);

	public void deleteById(Integer id);



	
	
}
