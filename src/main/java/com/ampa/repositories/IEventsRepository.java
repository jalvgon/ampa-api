package com.ampa.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ampa.models.Event;

@Repository
public interface IEventsRepository extends CrudRepository<Event, Long> {

	@Query(nativeQuery = true, value = "Select * from events where events.idEvent = ?")
	Event findEvent(Long idEvent);
	
	List<Event> findByTitular(String eventTitular);

}
