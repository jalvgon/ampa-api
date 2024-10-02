package com.ampa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ampa.handlers.EventHandler;
import com.ampa.models.Event;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/events")
@Tag(name = "Mantenimiento eventos")
@CrossOrigin
public class EventsController {
	

	@Autowired
	EventHandler eventHandler;
	
	@Operation(summary = "Listado de eventos", description = "Listado de eventos")
	@GetMapping("/events")
	public List<Event> getAllEvents(){
		return eventHandler.findAll();
	}
	
	@Operation(summary = "Detalle eventos", description = "Detalle eventos")
	@GetMapping("/events-byid")
	public Event findAllById(@RequestParam("idEvent") Long idEvent){
		return eventHandler.findById(idEvent);
	}
	
	@Transactional
	@Operation(summary = "Alta/Modificación de un evento", description = "Alta/Modificación de un evento")
	@PostMapping("/event")
	public Event saveHome(@RequestBody Event event) {
		return eventHandler.saveEvent(event);
	}
	
	@Transactional
	@Operation(summary = "Borrar un evento", description = "Borrar un evento")
	@DeleteMapping("/delete-event/{idEvent}")
	public void deleteNew(@PathVariable("idEvent") Long  idEvent) {
		eventHandler.deleteEvent(idEvent);
	}

}
