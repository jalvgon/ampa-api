package com.ampa.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ampa.models.Event;

@Service
public interface IEventService {
	
	public abstract List<Event> findAll();
	public abstract Event findById(Long idEvent);
	public abstract List<Event> findByTitular(String eventTitular);
	public abstract Event saveEvent(Event eventAux);
	public abstract void deleteEvent(Long idEvent);

}
