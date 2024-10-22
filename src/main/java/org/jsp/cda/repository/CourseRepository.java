package org.jsp.cda.repository;

import java.util.List;

import org.jsp.cda.entity.Course;
import org.jsp.cda.entity.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CourseRepository extends JpaRepository<Course, Integer> {


}
