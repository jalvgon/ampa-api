package com.ampa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ampa.handlers.UserHandler;
import com.ampa.models.User;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/users")
@Tag(name = "Mantenimiento usuarios")
@CrossOrigin
public class UserController {
	

	@Autowired
	UserHandler userHandler;
	
	@Operation(summary = "Listado de noticias", description = "Listado de noticias")
	@GetMapping("/users")
	public List<User> getAllUsers(){
		return userHandler.findAll();
	}
	
	@Operation(summary = "Detalle usuario", description = "Detalle usuario")
	@GetMapping("/users-byid")
	public User findAllById(@RequestParam("idUser") Long idUser){
		return userHandler.findById(idUser);
	}
	
	@Operation(summary = "Alta/Modificación de un usuario", description = "Alta/Modificación de un usuario")
	@PostMapping("/user")
	public User saveUser(@RequestBody User userAux) {
		return userHandler.saveUser(userAux);
	}
	
	@Operation(summary = "Borrar un usuario", description = "Borrar un usuario")
	@DeleteMapping("/delete-user")
	public void deleteUser(@Parameter long idUser) {
		userHandler.deleteUser(idUser);
	}

}
