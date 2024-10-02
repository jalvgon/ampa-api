package com.ampa.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ampa.models.New;

@Service
public interface INewsService {
	
	public abstract List<New> findAll();
	public abstract New findById(Long idNew);
	public abstract List<New> findByTitular(String newTitular);
	public abstract New saveNew(New newAux);
	public abstract void deleteNew(Long idNew);

}
