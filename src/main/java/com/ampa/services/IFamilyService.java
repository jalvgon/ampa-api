package com.ampa.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ampa.models.Family;

@Service
public interface IFamilyService {
	
	public abstract List<Family> findAll();
	public abstract Family findById(Long idFamily);
	public abstract List<Family> findByName(String name);
	public abstract Family saveFamily(Family family);
	public abstract void deleteFamily(Long idFamily);

}
