package com.ampa.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ampa.models.User;

@Repository
public interface IUserRepository extends CrudRepository<User, Long> {
	
	@Query(nativeQuery = true, value = "Select * from users where users.idUser = ?")
	User findUser(Long idUser);
	
	List<User> findByNameAndSubnames(String name, String subnames);
	
	@Query(nativeQuery = true, value = "Select * from users where login = ?1")
	User findByUsername(String login);

}
