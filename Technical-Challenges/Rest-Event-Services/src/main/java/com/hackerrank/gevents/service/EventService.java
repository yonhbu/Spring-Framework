package com.hackerrank.gevents.service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackerrank.gevents.exception.ValidType;
import com.hackerrank.gevents.model.Event;
import com.hackerrank.gevents.repository.EventRepository;
import com.hackerrank.gevents.exception.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;



@Service
@Slf4j
public class EventService implements IEventService{

	@Autowired
	EventRepository eventRepository;

	@Override
	public List<Event> find_Event() {
		return (List<Event>) eventRepository.findAll();
	}

	@Override
	public Optional<Event> getConsulEventById(Integer id) {	
		return eventRepository.findById(id); 
	}

	@Override
	public Event create_Event(Event event) {
		log.info("*******INIT CREATED EVENT ******");


		String type = event.getType();
		switch (type) {
		case "PushEvent":
			return create_EventOne(event);
		case "ReleaseEvent":
			return create_EventTwo(event);
		case "WatchEvent":
			return create_EventThree(event);
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

	
	public Event create_EventOne (Event event) {
		return eventRepository.save(event);
	}

	public Event create_EventTwo (Event event) {
		return eventRepository.save(event);
	}

	public Event create_EventThree (Event event) {
		return eventRepository.save(event);
	}

	@Override
	public List<Event> find_Event_by_RepoId(Integer id) {
		log.info("Request received for findById for repoId =" + id);
		
		 List<Event> listEvent = eventRepository.findEventsByRepoId(id);
		 
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

	@Override
	public List<Event> find_Event_by_UserId(Integer id) {
		log.info("Request received for findById for UserId =" + id);
		
		 List<Event> listEvent = eventRepository.findEventsByUserId(id);
		 
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
		return (List<Event>) eventRepository.findEventByisPublic(ispublic);
	}
	
	
	
	 public void delete_Event (Integer id){
	        try{
	        	eventRepository.deleteById(id);
	        }catch(Exception err){
	        	
	        }
	        
	    }

	@Override
	public Event updateEvent (Integer id, Event event) {
		
		Event eventInfo = eventRepository.findEventById(id);
	
        if (eventInfo == null) {
            throw new ResourceNotFoundException(Event.class, id);
        }
        eventInfo.setType(event.getType());
        eventInfo.setIsPublic(event.getIsPublic());
        eventInfo.setActorId(event.getActorId());
        eventInfo.setRepoId(event.getRepoId());
        
        eventRepository.save(eventInfo);
        return eventInfo;
	}

	
}
