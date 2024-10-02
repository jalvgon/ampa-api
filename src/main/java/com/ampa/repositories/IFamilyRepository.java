package com.ampa.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ampa.models.Family;

@Repository
public interface IFamilyRepository extends CrudRepository<Family, Long> {

	List<Family> findByName(String name);

}
