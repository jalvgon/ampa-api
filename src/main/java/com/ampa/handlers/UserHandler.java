package com.ampa.handlers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ampa.models.User;
import com.ampa.repositories.IUserRepository;
import com.ampa.services.IUserService;

@Component
public class UserHandler implements IUserService {
	
	@Autowired
	IUserRepository userRepository;

	@Override
	public List<User> findAll() {
		return (List<User>) userRepository.findAll();
	}

	@Override
	public User findById(Long idUser) {
		return userRepository.findUser(idUser);
	}

	@Override
	public List<User> findByNameAndSubnames(String name, String subnames) {
		return userRepository.findByNameAndSubnames(name, subnames);
	}

	@Override
	public User saveUser(User user) {
		User usuario = findById(user.getUserId());
		if(usuario == null || user.getUserId() == 0) {
			usuario = new User();
			usuario.setAntiquity(user.getAntiquity());
			usuario.setFamily(user.getFamily());
			usuario.setAttempts(0);
			usuario.setLogin(user.getLogin());
			usuario.setMail(user.getMail());
			usuario.setName(user.getName());
			usuario.setPassword(user.getPassword());
			usuario.setPhone(user.getPhone());
			usuario.setSubnames(user.getSubnames());
			
			user = userRepository.save(usuario);
			
		}else {
			if (usuario != null) {
				user = userRepository.save(user);
			}
		}
		return user;
	}

	@Override
	public void deleteUser(Long idUser) {
		userRepository.deleteById(idUser);
	}

}
