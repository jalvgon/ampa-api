package com.ampa.handlers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ampa.models.Ampa;
import com.ampa.repositories.IAmpaRepository;
import com.ampa.services.IAmpaService;

@Component
public class AmpaHandler implements IAmpaService {
	
	@Autowired
	IAmpaRepository ampaRepository;

	@Override
	public List<Ampa> findAll() {
		return (List<Ampa>) ampaRepository.findAll();
	}

	@Override
	public Ampa findById(Long idAmpa) {
		return ampaRepository.findById(idAmpa).orElse(null);
	}

	@Override
	public List<Ampa> findByName(String name) {
		return ampaRepository.findByName(name);
	}

	@Override
	public Ampa saveAmpa(Ampa ampaAux) {
		Ampa ampa = findById(ampaAux.getIdAmpa());
		if (ampa == null || ampaAux.getIdAmpa() == 0) {
			ampa = new Ampa();
			ampa.setDescription(ampaAux.getDescription());
			ampa.setAddress(ampaAux.getAddress());
			ampa.setEmail(ampaAux.getEmail());
			ampa.setName(ampaAux.getName());
			ampa.setPhone(ampaAux.getPhone());
			ampa.setSchool(ampaAux.getSchool());
			ampa.setFamilies(ampaAux.getFamilies());
			ampa.setSchool(ampaAux.getSchool());
			ampaAux = ampaRepository.save(ampa);
		} else {
			if (ampa != null) {
				ampaAux = ampaRepository.save(ampaAux);
			}
		}
		return ampaAux;
	}

	@Override
	public void deleteAmpa(Long idAmpa) {
		ampaRepository.deleteById(idAmpa);
	}

}
