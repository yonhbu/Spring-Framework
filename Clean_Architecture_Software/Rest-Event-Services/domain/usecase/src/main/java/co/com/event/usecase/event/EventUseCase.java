package co.com.event.usecase.event;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import co.com.event.helper.errors.ValidType;
import co.com.event.model.event.Event;
import co.com.event.model.event.gateways.EventGateway;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
public class EventUseCase {
	
	private final EventGateway eventRepository;
	

	public List<Event> findEvent() {
		return eventRepository.findEvent();
	}


	public Event createEvent(Event event) {
		log.info("*******INIT CREATED EVENT ******");
		
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
		
		 List<Event> listEvent = eventRepository.findEventbyRepoId(id);
		 
		 final List<Event> filtroEventByRepo =
				     listEvent.stream()
			         .filter(repo -> repo.getRepoId().equals(id))
			         .collect(Collectors.toList());
		 
		 for (Event event : filtroEventByRepo) {
				if (event.getRepoId().equals(id)) {
					return filtroEventByRepo;

				} 
		
	}
		return filtroEventByRepo;

	}

	
	public List<Event> findEventbyUserId(Integer id) {
		
		 List<Event> listEvent = eventRepository.findEventbyUserId(id);
		 
		 final List<Event> filtroEventByUser =
				     listEvent.stream()
			         .filter(user -> user.getActorId().equals(id))
			         .collect(Collectors.toList());
		 
		 for (Event event : filtroEventByUser) {
				if (event.getActorId().equals(id)) {
					return filtroEventByUser;

				} 
		
	}
		return filtroEventByUser;

	}
	
	public List<Event> getConsultByisPublicEvent (Boolean ispublic) {
		return eventRepository.findEventByisPublic(ispublic);
	}
	
	
	
	 public void deleteEvent (Integer id){
	        try{
	        	eventRepository.deleteById(id);
	        }catch(Exception err){
	        	
	        }
	        
	    }

	 
	public Event updateEvent (Integer id, Event event) throws Exception {
		
		Event eventInfo = eventRepository.findEventById(id);
	
        if (eventInfo == null) {
            throw new Exception();
        }
        eventInfo.setType(event.getType());
        eventInfo.setIsPublic(event.getIsPublic());
        eventInfo.setActorId(event.getActorId());
        eventInfo.setRepoId(event.getRepoId());
        
        eventRepository.createEvent(eventInfo);
        return eventInfo;
	}

	public Optional<Event> getConsulEventById(Integer id) {	
		return eventRepository.findById(id); 
	}
	
}
