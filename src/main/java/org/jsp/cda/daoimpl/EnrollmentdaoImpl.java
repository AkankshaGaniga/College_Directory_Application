package org.jsp.cda.daoimpl;

import java.util.List;
import java.util.Optional;

import org.jsp.cda.dao.EnrollementDao;
import org.jsp.cda.entity.Enrollment;
import org.jsp.cda.repository.EnrollmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EnrollmentdaoImpl implements EnrollementDao{

	@Autowired
	private EnrollmentRepository repo;
	
	@Override
	public Enrollment saveenrollment(Enrollment enrollment) {
		return repo.save(enrollment);
	}

	@Override
	public Optional<Enrollment> findById(int eid) {
		return repo.findById(eid);
	}

	@Override
	public List<Enrollment> findAllEnrollments() {
		return repo.findAll();
	}

	@Override
	public List<Enrollment> findEnrollmentsOfStudent(int sid) {
		return repo.findEnrollmentsOfStudents(sid);
	}

	@Override
	public List<Enrollment> findEnrollmentsOfCourse(int cid) {
		return repo.findEnrollmentsOfCourse(cid);
	}

}
