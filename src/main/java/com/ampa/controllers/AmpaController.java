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

import com.ampa.handlers.AmpaHandler;
import com.ampa.models.Ampa;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/ampas")
@Tag(name = "Mantenimiento ampas")
@CrossOrigin
public class AmpaController {
	
	@Autowired
	AmpaHandler ampaHandler;
	
	@Operation(summary = "Listado de ampas", description = "Listado de ampas")
	@GetMapping("/ampas")
	public List<Ampa> getAllAmpas(){
		return ampaHandler.findAll();
	}
	
	@Operation(summary = "Detalle ampa", description = "Detalle ampa")
	@GetMapping("/ampa-byid")
	public Ampa findAllById(@RequestParam("idAmpa") Long idAmpa){
		return ampaHandler.findById(idAmpa);
	}
	
	@Operation(summary = "Alta/Modificación de un ampa", description = "Alta/Modificación de un ampa")
	@PostMapping("/ampa")
	public Ampa saveAmpa(@RequestBody Ampa ampa) {
		return ampaHandler.saveAmpa(ampa);
	}
	
	@Operation(summary = "Borrar un nivel educativo", description = "Borrar un nivel educativo")
	@DeleteMapping("/delete-ampa")
	public void deleteAmpa(@Parameter long idAmpa) {
		ampaHandler.deleteAmpa(idAmpa);
	}
}
