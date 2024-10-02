package com.ampa.handlers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ampa.models.Event;
import com.ampa.repositories.IEventsRepository;
import com.ampa.services.IEventService;

@Component
public class EventHandler implements IEventService {
	
	@Autowired
	IEventsRepository eventRepository;

	@Override
	public List<Event> findAll() {
		return (List<Event>) eventRepository.findAll();
	}
	
	@Override
	public Event findById(Long idEvent) {
		return eventRepository.findEvent(idEvent);
	}

	@Override
	public List<Event> findByTitular(String eventTitular) {
		return eventRepository.findByTitular(eventTitular);
	}

	@Override
	public Event saveEvent(Event eventAux) {
		
		Event evento = findById(eventAux.getIdEvent());
		if(evento == null || eventAux.getIdEvent() == 0) {
			evento = new Event();
			evento.setImage(null);
			evento.setText(eventAux.getText());
			evento.setTitular(eventAux.getTitular());
			evento.setAmpa(eventAux.getAmpa());
			eventAux = eventRepository.save(evento);
			
		}else {
			if (evento != null) {
				eventAux = eventRepository.save(eventAux);
			}
		}
		return eventAux;
	}

	@Override
	public void deleteEvent(Long idEvent) {
		Event eventAux = findById(idEvent);
		if (eventAux != null)   eventRepository.delete(eventAux);
	}

}
