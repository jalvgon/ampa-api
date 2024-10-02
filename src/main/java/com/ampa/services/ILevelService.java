package com.ampa.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ampa.models.Level;

@Service
public interface ILevelService {
	
	public abstract List<Level> findAll();
	public abstract Level findById(Long idLevel);
	public abstract List<Level> findByDescription(String description);
	public abstract Level saveLevel(Level level);
	public abstract void deleteLevel(Long idLevel);

}
