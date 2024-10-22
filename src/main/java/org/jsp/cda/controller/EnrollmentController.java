package org.jsp.cda.controller;

import org.jsp.cda.entity.Enrollment;
import org.jsp.cda.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/enrollments")
public class EnrollmentController {
	
	@Autowired
	private EnrollmentService service;
	
	@PostMapping(value = "/{sid}/{cid}")
	public ResponseEntity<?> saveEnrollemnt(@PathVariable int cid,@PathVariable int sid)
	{
		return service.saveEnrollment(cid,sid);
	}
	
	@GetMapping(value = "/{eid}")
	public ResponseEntity<?> findEnrollmentById(@PathVariable int eid)
	{
		return service.findEnrollmentById(eid);
	}
	
	@GetMapping
	public ResponseEntity<?> findAllEnrollments()
	{
		return service.findAllEnrollments();
	}
	
	@GetMapping("/student/{sid}")
	public ResponseEntity<?> findEnrollmentByStudentId(@PathVariable int sid)
	{
		return service.findEnrollmentByStudentId(sid);
	}
	
	@GetMapping("/course/{cid}")
	public ResponseEntity<?> findEnrollmentsByCourseId(@PathVariable int cid)
	{
		return service.findEnrollmentsByCourseId(cid);
	}
}
