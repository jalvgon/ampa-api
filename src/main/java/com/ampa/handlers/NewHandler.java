package com.ampa.handlers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ampa.models.New;
import com.ampa.repositories.INewsRepository;
import com.ampa.services.INewsService;

@Component
public class NewHandler implements INewsService {
	
	@Autowired
	INewsRepository newsRepository;

	@Override
	public List<New> findAll() {
		return (List<New>) newsRepository.findAll();
	}

	@Override
	public New findById(Long idNew) {
		return newsRepository.findNew(idNew);
	}

	@Override
	public List<New> findByTitular(String newTitular) {
		return newsRepository.findByTitular(newTitular);
	}

	@Override
	public New saveNew(New newAux) {
		
		New noticia = findById(newAux.getIdNew());
		if(noticia == null || newAux.getIdNew() == 0) {
			noticia = new New();
			noticia.setImage(null);
			noticia.setText(newAux.getText());
			noticia.setTitular(newAux.getTitular());
			noticia.setAmpa(newAux.getAmpa());
			newAux = newsRepository.save(noticia);
			
		}else {
			if (noticia != null) {
				newAux = newsRepository.save(newAux);
			}
		}
		return newAux;
	}

	@Override
	public void deleteNew(Long idNew) {
		New newAux = findById(idNew);
		if (newAux != null)   newsRepository.delete(newAux);
	}

}
