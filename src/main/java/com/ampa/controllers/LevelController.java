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

import com.ampa.handlers.LevelHandler;
import com.ampa.models.Level;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/levels")
@Tag(name = "Mantenimiento niveles educativos")
@CrossOrigin
public class LevelController {
	

	@Autowired
	LevelHandler levelHandler;
	
	@Operation(summary = "Listado de niveles educativos", description = "Listado de niveles educativos")
	@GetMapping("/levels")
	public List<Level> getAllLevels(){
		return levelHandler.findAll();
	}
	
	@Operation(summary = "Detalle niveles educativos", description = "Detalle niveles educativos")
	@GetMapping("/level-byid")
	public Level findAllById(@RequestParam("idUser") Long idLevel){
		return levelHandler.findById(idLevel);
	}
	
	@Operation(summary = "Alta/Modificación de un nivel educativo", description = "Alta/Modificación de un nivel educativo")
	@PostMapping("/level")
	public Level saveLevel(@RequestBody Level level) {
		return levelHandler.saveLevel(level);
	}
	
	@Operation(summary = "Borrar un nivel educativo", description = "Borrar un nivel educativo")
	@DeleteMapping("/delete-level")
	public void deleteLevel(@Parameter long idLevel) {
		levelHandler.deleteLevel(idLevel);
	}

}
