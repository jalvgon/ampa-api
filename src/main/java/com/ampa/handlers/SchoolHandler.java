package com.ampa.handlers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ampa.models.School;
import com.ampa.repositories.ISchoolRepository;
import com.ampa.services.ISchoolService;

@Component
public class SchoolHandler implements ISchoolService {
	
	@Autowired
	ISchoolRepository schoolRepository;

	@Override
	public List<School> findAll() {
		return (List<School>) schoolRepository.findAll();
	}

	@Override
	public School findById(Long idSchool) {
		return schoolRepository.findById(idSchool).orElse(null);
	}

	@Override
	public List<School> findByName(String name) {
		return schoolRepository.findByName(name);
	}

	@Override
	public School saveSchool(School schoolAux) {
		School school = findById(schoolAux.getIdSchool());
		if (school == null || schoolAux.getIdSchool() == 0) {
			school = new School();
			school.setAddress(schoolAux.getAddress());
			school.setAmpas(schoolAux.getAmpas());
			school.setDescription(school.getDescription());
			school.setName(schoolAux.getName());
			schoolAux = schoolRepository.save(school);
		} else {
			if (school != null) {
				schoolAux = schoolRepository.save(schoolAux);
			}
		}
		return schoolAux;
	}

	@Override
	public void deleteSchool(Long idSchool) {
		schoolRepository.deleteById(idSchool);
	}

}
