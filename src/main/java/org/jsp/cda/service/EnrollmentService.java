package org.jsp.cda.service;

import org.jsp.cda.entity.Enrollment;
import org.springframework.http.ResponseEntity;

public interface EnrollmentService {


	ResponseEntity<?> saveEnrollment(int cid, int sid);

	ResponseEntity<?> findEnrollmentById(int eid);

	ResponseEntity<?> findAllEnrollments();

	ResponseEntity<?> findEnrollmentByStudentId(int sid);

	ResponseEntity<?> findEnrollmentsByCourseId(int cid);

}
