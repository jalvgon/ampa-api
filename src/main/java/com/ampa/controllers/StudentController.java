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

import com.ampa.handlers.StudentHandler;
import com.ampa.models.Student;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/students")
@Tag(name = "Mantenimiento estudiantes")
@CrossOrigin
public class StudentController {
	

	@Autowired
	StudentHandler studentHandler;
	
	@Operation(summary = "Listado de estudiantes", description = "Listado de estudiantes")
	@GetMapping("/students")
	public List<Student> getAllStudents(){
		return studentHandler.findAll();
	}
	
	@Operation(summary = "Detalle estudiante", description = "Detalle estudiante")
	@GetMapping("/students-byid")
	public Student findAllById(@RequestParam("idUser") Long idStudent){
		return studentHandler.findById(idStudent);
	}
	
	@Operation(summary = "Alta/Modificación de un estudiante", description = "Alta/Modificación de un estudiante")
	@PostMapping("/student")
	public Student saveStudent(@RequestBody Student studentAux) {
		return studentHandler.saveStudent(studentAux);
	}
	
	@Operation(summary = "Borrar un estudiante", description = "Borrar un estudiante")
	@DeleteMapping("/delete-student")
	public void deleteStudent(@Parameter long idStudent) {
		studentHandler.deleteStudent(idStudent);
	}

}
