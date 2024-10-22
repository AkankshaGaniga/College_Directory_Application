package org.jsp.cda.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.cda.entity.Enrollment;

public interface EnrollementDao {

	Enrollment saveenrollment(Enrollment enrollment);

	Optional<Enrollment> findById(int eid);

	List<Enrollment> findAllEnrollments();

	List<Enrollment> findEnrollmentsOfStudent(int sid);

	List<Enrollment> findEnrollmentsOfCourse(int cid);



}
