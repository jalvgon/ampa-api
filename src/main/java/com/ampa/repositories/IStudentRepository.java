package com.ampa.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ampa.models.Student;

@Repository
public interface IStudentRepository extends CrudRepository<Student, Long> {
	
	@Query(nativeQuery = true, value = "Select * from students where students.idStudent = ?")
	Student findStudent(Long idStudent);

	List<Student> findByNameAndSubname(String name, String subname);

}
