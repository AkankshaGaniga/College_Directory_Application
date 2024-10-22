package org.jsp.cda.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.cda.entity.Student;
import org.springframework.http.ResponseEntity;

public interface StudentDao {

	Student saveStudent(Student student);

	Optional<Student> findById(int uid);

	List<Student> findAllStudents();


}
