package com.ampa.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ampa.models.Ampa;

@Service
public interface IAmpaService {
	
	public abstract List<Ampa> findAll();
	public abstract Ampa findById(Long idAmpa);
	public abstract List<Ampa> findByName(String name);
	public abstract Ampa saveAmpa(Ampa ampa);
	public abstract void deleteAmpa(Long idAmpa);

}
