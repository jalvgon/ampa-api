package com.ampa.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ampa.models.User;

@Service
public interface IUserService {
	
	public abstract List<User> findAll();
	public abstract User findById(Long idUser);
	public abstract List<User> findByNameAndSubnames(String name, String subnames);
	public abstract User saveUser(User user);
	public abstract void deleteUser(Long idUser);

}
