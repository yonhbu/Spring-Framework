package co.com.event.usecase.event;


import java.util.List;
import java.util.Optional;

import co.com.event.model.commons.ValidType;
import co.com.event.model.event.Event;
import co.com.event.model.event.gateways.EventGateway;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class EventUseCase {

	private final EventGateway eventRepository;


	public List<Event> findEvent() {
		return eventRepository.findEvent();
	}


	public Event createEvent(Event event) {

		String type = event.getType();
		switch (type) {
		case "PushEvent":
			return createEventOne(event);
		case "ReleaseEvent":
			return createEventTwo(event);
		case "WatchEvent":
			return createEventThree(event);
		default:
		}
		throw new ValidType("Type user not Valid");

	} 




	public int givenTypeIsValid (Event event) {	

		String type = event.getType();

		int result;
		switch (type) {
		case "PushEvent":
			result = 1; 
			break;
		case "ReleaseEvent":
			result = 2;
			break;
		case "WatchEvent":
			result = 3;
			break;
		default:
			result = 0;
			break;
		}
		return result;

	}


	public Event createEventOne (Event event) {
		return eventRepository.createEvent(event);
	}

	public Event createEventTwo (Event event) {
		return eventRepository.createEvent(event);
	}

	public Event createEventThree (Event event) {
		return eventRepository.createEvent(event);
	}


	public List<Event> findEventbyRepoId(Integer id) {
		return eventRepository.findEventbyRepoId(id);
	}


	public List<Event> findEventbyUserId(Integer id) {
		return eventRepository.findEventbyUserId(id);
	}

	public List<Event> getConsultByisPublicEvent (Boolean ispublic) {
		return eventRepository.findEventByisPublic(ispublic);
	}

	public Optional<Event> getConsulEventById(Integer id) {	
		return eventRepository.findById(id); 
	}

}
