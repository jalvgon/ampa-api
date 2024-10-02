package com.ampa.handlers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ampa.models.Level;
import com.ampa.repositories.ILevelRepository;
import com.ampa.services.ILevelService;

@Component
public class LevelHandler implements ILevelService {

	@Autowired
	ILevelRepository levelRepository;

	@Override
	public List<Level> findAll() {
		return (List<Level>) levelRepository.findAll();
	}

	@Override
	public Level findById(Long idLevel) {
		return levelRepository.findLevel(idLevel);
	}

	@Override
	public List<Level> findByDescription(String description) {
		return levelRepository.findByDescription(description);
	}

	@Override
	public Level saveLevel(Level levelAux) {
		Level level = findById(levelAux.getIdLevel());
		if (level == null || levelAux.getIdLevel() == 0) {
			level = new Level();
			level.setDescription(levelAux.getDescription());
			levelAux = levelRepository.save(level);
		} else {
			if (level != null) {
				levelAux = levelRepository.save(levelAux);
			}
		}
		return levelAux;
	}

	@Override
	public void deleteLevel(Long idLevel) {
		levelRepository.deleteById(idLevel);
	}

}
