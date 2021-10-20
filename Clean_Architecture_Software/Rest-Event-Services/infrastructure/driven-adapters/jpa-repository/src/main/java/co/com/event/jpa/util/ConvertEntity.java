package co.com.event.jpa.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

import co.com.event.jpa.EventDataJPA;
import co.com.event.jpa.EventRepositoryJPA;
import co.com.event.model.commons.ResourceNotFoundException;
import co.com.event.model.event.Event;
import co.com.event.model.event.gateways.EventGateway;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ConvertEntity implements EventGateway {

	private final EventRepositoryJPA eventRepositoryJPA;

	@Override
	public List<Event> findEvent() {

		List<EventDataJPA> eventDataJPA = (List<EventDataJPA>) eventRepositoryJPA.findAll();
		// Convert Entity JPA to Entity Domain
		return ObjectMapperUtils.mapAll(eventDataJPA, Event.class);

	}

	@Override
	public List<Event> findEventbyRepoId(Integer id) {

		List<Event> listEventEntity = new ArrayList<>();
		List<EventDataJPA> listEventDataJPA = eventRepositoryJPA.findEventDataJPAByRepoId(id);

		final List<EventDataJPA> filtroEventDataJPAByRepo =
				listEventDataJPA.stream()
				.filter(repo -> repo.getRepoId().equals(id))
				.collect(Collectors.toList());

		for (EventDataJPA eventDataJPA : filtroEventDataJPAByRepo) {
			if (eventDataJPA.getRepoId().equals(id)) {

				listEventEntity = ObjectMapperUtils.mapAll(filtroEventDataJPAByRepo, Event.class);
				return listEventEntity;

			} 

		}
		return listEventEntity;

	}


	@Override
	public List<Event> findEventbyUserId(Integer id) {

		List<Event> listEventEntity = new ArrayList<>();
		List<EventDataJPA> listEventDataJPA = eventRepositoryJPA.findEventDataJPAByUserId(id);

		final List<EventDataJPA> filtroEventDataJPAByUser =
				listEventDataJPA.stream()
				.filter(user -> user.getActorId().equals(id))
				.collect(Collectors.toList());

		for (EventDataJPA eventDataJPA : filtroEventDataJPAByUser) {
			if (eventDataJPA.getActorId().equals(id)) {
				listEventEntity = ObjectMapperUtils.mapAll(filtroEventDataJPAByUser, Event.class);
				return listEventEntity;

			} 

		}
		return listEventEntity;

	}


	@Override
	public Event createEvent(Event entityEvent) {

		// Convert Entity Domain to Entity JPA
		EventDataJPA eventRequest =  ObjectMapperUtils.map(entityEvent, EventDataJPA.class);
		EventDataJPA eventDataJPA = eventRepositoryJPA.save(eventRequest);

		// Convert Entity JPA to Entity Domain
		return ObjectMapperUtils.map(eventDataJPA, Event.class);
	}


	@Override
	public List<Event> findEventByisPublic(Boolean ispublic) {

		List<EventDataJPA> eventDataJPAInfo = eventRepositoryJPA.findEventDataJPAByisPublic(ispublic);
		return ObjectMapperUtils.mapAll(eventDataJPAInfo, Event.class);

	}

	@Override
	public Event findEventById(Integer id) {
		EventDataJPA eventDataJPA = eventRepositoryJPA.findEventDataJPAById(id);
		return ObjectMapperUtils.map(eventDataJPA, Event.class);
	}

	@Override
	public Optional<Event> findById(Integer id) {
		Optional<EventDataJPA> optionalEventDataJPA = eventRepositoryJPA.findById(id);
		return optionalEventDataJPA.map(this::getEventHelpBeforeMethod);

	}

	
	// Method Aux.
	private Event getEventHelpBeforeMethod (EventDataJPA eventDataJPA) {

		if(eventDataJPA != null) {			 
			return ObjectMapperUtils.map(eventDataJPA, Event.class);
		} else {
			return null;
		}
	}


	
	@Override
	public Event updateEvent(Integer id, Event event) {

		EventDataJPA eventDataJPAInfo = eventRepositoryJPA.findEventDataJPAById(id);

		if (eventDataJPAInfo == null) {
			throw new ResourceNotFoundException(Event.class, id);
		}
		eventDataJPAInfo.setType(event.getType());
		eventDataJPAInfo.setIsPublic(event.getIsPublic());
		eventDataJPAInfo.setActorId(event.getActorId());
		eventDataJPAInfo.setRepoId(event.getRepoId());

		eventRepositoryJPA.save(eventDataJPAInfo);
		return ObjectMapperUtils.map(eventDataJPAInfo, Event.class);


	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stu
	}


}
