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

import com.ampa.handlers.FamilyHandler;
import com.ampa.models.Family;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/families")
@Tag(name = "Mantenimiento familias")
@CrossOrigin
public class FamilyController {
	
	@Autowired
	FamilyHandler familyHandler;
	
	@Operation(summary = "Listado de familias", description = "Listado de familias")
	@GetMapping("/families")
	public List<Family> getAllFamilies(){
		return familyHandler.findAll();
	}
	
	@Operation(summary = "Detalle familia", description = "Detalle familia")
	@GetMapping("/family-byid")
	public Family findAllById(@RequestParam("idFamily") Long idFamily){
		return familyHandler.findById(idFamily);
	}
	
	@Operation(summary = "Alta/Modificación de una familia", description = "Alta/Modificación de una familia")
	@PostMapping("/family")
	public Family saveFamily(@RequestBody Family family) {
		return familyHandler.saveFamily(family);
	}
	
	@Operation(summary = "Borrar un nivel educativo", description = "Borrar un nivel educativo")
	@DeleteMapping("/delete-family")
	public void deleteLevel(@Parameter long idFamily) {
		familyHandler.deleteFamily(idFamily);
	}
}
