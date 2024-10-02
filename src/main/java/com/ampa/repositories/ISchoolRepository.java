package com.ampa.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ampa.models.School;

@Repository
public interface ISchoolRepository extends CrudRepository<School, Long> {

	List<School> findByName(String name);

}
