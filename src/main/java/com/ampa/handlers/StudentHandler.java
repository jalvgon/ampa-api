package com.ampa.handlers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ampa.models.Student;
import com.ampa.repositories.IStudentRepository;
import com.ampa.services.IStudentService;

@Component
public class StudentHandler implements IStudentService {
	
	@Autowired
	IStudentRepository studentRepository;

	@Override
	public List<Student> findAll() {
		return (List<Student>) studentRepository.findAll();
	}

	@Override
	public Student findById(Long idStudent) {
		return studentRepository.findStudent(idStudent);
	}

	@Override
	public List<Student> findByNameAndSubname(String name, String subname) {
		return studentRepository.findByNameAndSubname(name, subname);
	}

	@Override
	public Student saveStudent(Student student) {
		Student estudiante = findById(student.getIdStudent());
		if(estudiante == null || student.getIdStudent() == 0) {
			
			estudiante = new Student();
			estudiante.setBirthdate(student.getBirthdate());
			estudiante.setFamily(student.getFamily());
			estudiante.setLevel(student.getLevel());
			estudiante.setName(student.getName());
			estudiante.setSubname(student.getSubname());
			
			student = studentRepository.save(estudiante);
			
		}else {
			if (estudiante != null) {
				student = studentRepository.save(estudiante);
			}
		}
		return student;
	}

	@Override
	public void deleteStudent(Long idStudent) {
		studentRepository.deleteById(idStudent);
	}

}
