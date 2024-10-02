package com.ampa.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ampa.models.Level;

@Repository
public interface ILevelRepository extends CrudRepository<Level, Long> {

	
	@Query(nativeQuery = true, value = "Select * from levels where levels.idLevel = ?")
	Level findLevel(Long idLevel);

	List<Level> findByDescription(String description);

}


