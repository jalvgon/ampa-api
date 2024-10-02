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

import com.ampa.handlers.SchoolHandler;
import com.ampa.models.School;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/schools")
@Tag(name = "Mantenimiento Colegios")
@CrossOrigin
public class SchoolController {
	
	@Autowired
	SchoolHandler schoolHandler;
	
	@Operation(summary = "Listado de colegios", description = "Listado de colegios")
	@GetMapping("/schools")
	public List<School> getAllSchools(){
		return schoolHandler.findAll();
	}
	
	@Operation(summary = "Detalle colegio", description = "Detalle colegio")
	@GetMapping("/school-byid")
	public School findAllById(@RequestParam("idSchool") Long idSchool){
		return schoolHandler.findById(idSchool);
	}
	
	@Operation(summary = "Alta/Modificación de un colegio", description = "Alta/Modificación de un colegio")
	@PostMapping("/school")
	public School saveSchool(@RequestBody School school) {
		return schoolHandler.saveSchool(school);
	}
	
	@Operation(summary = "Borrar un colegio", description = "Borrar un colegio")
	@DeleteMapping("/delete-school")
	public void deleteStudent(@Parameter long idSchool) {
		schoolHandler.deleteSchool(idSchool);
	}
}
