package com.ampa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ampa.handlers.NewHandler;
import com.ampa.models.New;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/news")
@Tag(name = "Mantenimiento noticias")
@CrossOrigin
public class NewController {
	

	@Autowired
	NewHandler newHandler;
	
	@Operation(summary = "Listado de noticias", description = "Listado de noticias")
	@GetMapping("/news")
	public List<New> getAllNews(){
		return newHandler.findAll();
	}
	
	@Operation(summary = "Detalle noticia", description = "Detalle noticia")
	@GetMapping("/news-byid")
	public New findAllById(@RequestParam("idNew") Long idNew){
		return newHandler.findById(idNew);
	}
	
	@Transactional
	@Operation(summary = "Alta/Modificación de una noticia", description = "Alta/Modificación de una noticia")
	@PostMapping("/new")
	public New saveHome(@RequestBody New newAux) {
		return newHandler.saveNew(newAux);
	}
	
	@Transactional
	@Operation(summary = "Borrar una noticia", description = "Borrar una noticia")
	@DeleteMapping("/delete-new/{idNew}")
	public void deleteNew(@PathVariable("idNew") Long  idNew) {
		newHandler.deleteNew(idNew);
	}

}
