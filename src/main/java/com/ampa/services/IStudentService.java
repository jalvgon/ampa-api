package com.ampa.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ampa.models.Student;

@Service
public interface IStudentService {
	
	public abstract List<Student> findAll();
	public abstract Student findById(Long idStudent);
	public abstract List<Student> findByNameAndSubname(String name, String subname);
	public abstract Student saveStudent(Student student);
	public abstract void deleteStudent(Long idStudent);

}
