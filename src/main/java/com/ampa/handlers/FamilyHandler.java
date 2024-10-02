package com.ampa.handlers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ampa.models.Family;
import com.ampa.repositories.IFamilyRepository;
import com.ampa.services.IFamilyService;

@Component
public class FamilyHandler implements IFamilyService {
	
	@Autowired
	IFamilyRepository familyRepository;

	@Override
	public List<Family> findAll() {
		return (List<Family>) familyRepository.findAll();
	}

	@Override
	public Family findById(Long idFamily) {
		return familyRepository.findById(idFamily).orElse(null);
	}

	@Override
	public List<Family> findByName(String name) {
		return familyRepository.findByName(name);
	}

	@Override
	public Family saveFamily(Family familyAux) {
		Family family = findById(familyAux.getIdFamily());
		if (family == null || familyAux.getIdFamily() == 0) {
			family = new Family();
			family.setDescription(familyAux.getDescription());
			family.setAmpa(familyAux.getAmpa());
			family.setName(familyAux.getName());
			family.setStudents(familyAux.getStudents());
			familyAux = familyRepository.save(family);
		} else {
			if (family != null) {
				familyAux = familyRepository.save(familyAux);
			}
		}
		return familyAux;
	}

	@Override
	public void deleteFamily(Long idFamily) {
		familyRepository.deleteById(idFamily);
	}

}
