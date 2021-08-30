package com.hackerrank.gevents.controller;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hackerrank.gevents.dto.EventRequestDTO;
import com.hackerrank.gevents.dto.EventResponseDTO;
import com.hackerrank.gevents.exception.EventDoesNotExistException;
import com.hackerrank.gevents.model.Event;
import com.hackerrank.gevents.service.EventService;

import lombok.extern.slf4j.Slf4j;


@RestController
@Slf4j
public class EventController {
	
	@Autowired
	EventService eventService;
	
	
	@PostMapping("/events")
	public ResponseEntity<EventResponseDTO> createEvent (@RequestBody EventRequestDTO eventDTO) {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setAmbiguityIgnored(true);

		// convert DTO to entity
		Event eventRequest = modelMapper.map(eventDTO, Event.class);
		Event event = eventService.create_Event(eventRequest);

		// convert entity to DTO
		EventResponseDTO eventResponse = modelMapper.map(event, EventResponseDTO.class);
		return new ResponseEntity<>(eventResponse, HttpStatus.CREATED);

	}
	

	
	@GetMapping("/events")
	public ResponseEntity<List<Event>> getUsuarios (@RequestParam Optional<Boolean> ispublic) {
		
		if(ispublic.isPresent()) {

			return new ResponseEntity<>(eventService.getConsultByisPublicEvent(ispublic.get()), HttpStatus.OK);

		} else {
			return new ResponseEntity<> (eventService.find_Event(), HttpStatus.OK);
		}

		
	}
	
	
	@GetMapping("/events/{eventId}")
	public ResponseEntity<EventResponseDTO> getEventxID (@PathVariable("eventId") int eventId) {
		
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setAmbiguityIgnored(true);

		Event event = eventService.getConsulEventById(eventId)
				 .orElseThrow(() -> new EventDoesNotExistException(eventId));

		EventResponseDTO eventResponseDTO = modelMapper.map(event, EventResponseDTO.class);
		return new ResponseEntity<>(eventResponseDTO, HttpStatus.OK);
		
	}
	
	
	@GetMapping("/repos/{repoId}/events")
	public ResponseEntity<List<Event>> getEventxRepoId (@PathVariable("repoId") Integer repoId) {
	
		log.info("Request received for findById for repoId =" + repoId);
		List<Event> event = eventService.find_Event_by_RepoId(repoId);
		
		if (event != null) {
		    return new ResponseEntity<>(event, HttpStatus.OK);
		} else {
		    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		
	}
	
	@GetMapping("/users/{userId}/events")
	public ResponseEntity<List<Event>> getEventxUserId (@PathVariable("userId") Integer userId) {
	
		log.info("Request received for findById for userId =" + userId);
		List<Event> event = eventService.find_Event_by_UserId(userId);
		
		if (event != null) {
		    return new ResponseEntity<>(event, HttpStatus.OK);
		} else {
		    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		
	}

}
