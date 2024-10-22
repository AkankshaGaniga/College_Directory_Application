package org.jsp.cda.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.jsp.cda.dao.CourseDao;
import org.jsp.cda.dao.EnrollementDao;
import org.jsp.cda.dao.StudentDao;
import org.jsp.cda.entity.Course;
import org.jsp.cda.entity.Enrollment;
import org.jsp.cda.entity.Student;
import org.jsp.cda.exception.InvalidCourseIdException;
import org.jsp.cda.exception.InvalidEnrollmentIdException;
import org.jsp.cda.exception.InvalidStudentIdException;
import org.jsp.cda.exception.NoEnrollmentsFoundException;
import org.jsp.cda.responsestructure.ResponseStructure;
import org.jsp.cda.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EnrollmentServcieImpl implements EnrollmentService {

	@Autowired
	private EnrollementDao eDao;

	@Autowired
	private StudentDao sDao;

	@Autowired
	private CourseDao cDao;

	@Override
	public ResponseEntity<?> saveEnrollment(int cid, int sid) {
		Optional<Course> optional1 = cDao.findById(cid);
		Optional<Student> optional2 = sDao.findById(sid);

//		if (optional1.isEmpty())
//			throw new RuntimeException("Invalid Course id ");
//
//		if (optional2.isEmpty())
//			throw new RuntimeException("Invalid Student id ");

		if (optional1.isEmpty())
			throw InvalidCourseIdException.builder().message("Invalid Course Id... please check...").build();
		if (optional2.isEmpty())
			throw InvalidStudentIdException.builder().message("Invalid Student Id... please check...").build();
		Course course = optional1.get();
		Student student = optional2.get();
		Enrollment enrollment = Enrollment.builder().course(course).student(student).build();
		enrollment = eDao.saveenrollment(enrollment);
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
				.message("Enrollment done successfully...").body(enrollment).build());
	}

	@Override
	public ResponseEntity<?> findEnrollmentById(int eid) {
		Optional<Enrollment> optional = eDao.findById(eid);
		if (optional.isEmpty())
			throw InvalidEnrollmentIdException.builder().message("Invalid Enrollment Id...").build();
		Enrollment enrollment = optional.get();
		return ResponseEntity.status(HttpStatus.FOUND).body(ResponseStructure.builder().status(HttpStatus.FOUND.value())
				.message("Enrollment Found successfully...").body(enrollment).build());
	}

	@Override
	public ResponseEntity<?> findAllEnrollments() {
		List<Enrollment> el = eDao.findAllEnrollments();
		if (el.isEmpty())
			throw NoEnrollmentsFoundException.builder().message("No Enrollments Found...").build();
		return ResponseEntity.status(HttpStatus.FOUND).body(ResponseStructure.builder().status(HttpStatus.FOUND.value())
				.message("All Enrollments Found successfully...").body(el).build());
	}

	@Override
	public ResponseEntity<?> findEnrollmentByStudentId(int sid) {
		Optional<Student> optional = sDao.findById(sid);
		if (optional.isEmpty())
			throw InvalidStudentIdException.builder().message("invalid student Id... Please check...").build();
		List<Enrollment> el = eDao.findEnrollmentsOfStudent(sid);
		if (el.isEmpty())
			throw NoEnrollmentsFoundException.builder().message("No Enrollments Found For The Given Student...")
					.build();
		return ResponseEntity.status(HttpStatus.FOUND).body(ResponseStructure.builder().status(HttpStatus.FOUND.value())
				.message("All Enrollments Of The Student Found successfully...").body(el).build());
	}

	@Override
	public ResponseEntity<?> findEnrollmentsByCourseId(int cid) {
		Optional<Course> optional = cDao.findById(cid);
		if (optional.isEmpty())
			throw InvalidCourseIdException.builder().message("invalid Course Id... Please check...").build();
		List<Enrollment> el = eDao.findEnrollmentsOfCourse(cid); 
		if (el.isEmpty())
			throw NoEnrollmentsFoundException.builder().message("No Enrollments Found For The Given Course...").build();
		return ResponseEntity.status(HttpStatus.FOUND).body(ResponseStructure.builder().status(HttpStatus.FOUND.value())
				.message("All Enrollments Of The Course Found successfully...").body(el).build());
	}

}
