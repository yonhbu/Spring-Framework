package com.hackerrank.gevents.service;


import java.util.List;
import java.util.Optional;

import com.hackerrank.gevents.model.Event;


public interface IEventService {
	
	public List<Event> find_Event ();
	
	public List<Event> find_Event_by_RepoId (Integer id);
	
	public List<Event> find_Event_by_UserId (Integer id);
	
	public Event create_Event (Event event);
	
	public Optional<Event> getConsulEventById(Integer id);
	
}
