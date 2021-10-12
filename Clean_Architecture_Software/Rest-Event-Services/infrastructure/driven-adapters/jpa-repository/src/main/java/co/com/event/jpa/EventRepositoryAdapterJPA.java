package co.com.event.jpa;



import co.com.event.jpa.helper.AdapterOperations;
import co.com.event.model.event.Event;
import co.com.event.model.event.gateways.EventGateway;

import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class EventRepositoryAdapterJPA  extends AdapterOperations<Event, EventDataJPA, Integer, EventRepositoryJPA>
        implements EventGateway {

    public EventRepositoryAdapterJPA (EventRepositoryJPA repository, ObjectMapper mapper) {
        super(repository, mapper, d -> mapper.mapBuilder(d, Event.EventBuilder.class).build());
    }

	@Override
	public List<Event> findEvent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Event> findEventbyRepoId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Event> findEventbyUserId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Event createEvent(Event event) {
		 return super.save(event);
	}

	@Override
	public Optional<Event> getConsulEventById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Event updateEvent(Integer id, Event event) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Event> findEventByisPublic(Boolean ispublic) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Event findEventById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Event> findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}


}
