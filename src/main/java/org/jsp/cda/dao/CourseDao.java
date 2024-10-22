package org.jsp.cda.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.cda.entity.Course;
import org.jsp.cda.entity.Enrollment;

public interface CourseDao {

	Course save(Course course);

	Optional<Course> findById(int id);

	List<Course> findAllCourses();


}
