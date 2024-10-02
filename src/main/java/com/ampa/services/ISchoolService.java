package com.ampa.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ampa.models.School;

@Service
public interface ISchoolService {
	
	public abstract List<School> findAll();
	public abstract School findById(Long idSchool);
	public abstract List<School> findByName(String name);
	public abstract School saveSchool(School school);
	public abstract void deleteSchool(Long idSchool);

}
