package org.jsp.cda.repository;

import java.util.List;

import org.jsp.cda.entity.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Integer> {

	@Query("SELECT e FROM Enrollment e WHERE e.student.id = :sid")
	List<Enrollment> findEnrollmentsOfStudents(int sid);

	@Query("SELECT e FROM Enrollment e WHERE e.course.id = :cid")
	List<Enrollment> findEnrollmentsOfCourse(int cid);

}
