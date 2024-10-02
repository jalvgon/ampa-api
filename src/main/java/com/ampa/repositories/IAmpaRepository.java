package com.ampa.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ampa.models.Ampa;

@Repository
public interface IAmpaRepository extends CrudRepository<Ampa, Long> {
	
	List<Ampa> findByName(String name);

}
