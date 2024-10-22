package org.jsp.cda.controller;

import java.util.Optional;

import org.jsp.cda.entity.Course;
import org.jsp.cda.entity.Faculty;
import org.jsp.cda.service.CourseService;
import org.jsp.cda.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/courses")
@RestController
public class CourseController {

	@Autowired
	private CourseService service;
	
	@Autowired
	private FacultyService facultyservice;
	
	@PostMapping
	public ResponseEntity<?> saveCourse(@RequestBody Course course)
	{
		return service.saveCourse(course);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> findCourseById(@PathVariable int id)
	{
		return service.findById(id);
	}
	
	@GetMapping
	public ResponseEntity<?> findAllCourses()
	{
		return service.findAllCourses();
	}
	
	@PatchMapping("/faculty/{cid}/{fid}")
	public ResponseEntity<?> setFacultyToCourse(@PathVariable int cid, @PathVariable int fid) {
		return service.setFacultyToCourse(cid,fid);
	}
	
	@PatchMapping("/department/{cid}/{did}")
	public ResponseEntity<?> setDepartmentToCourse(@PathVariable int cid,@PathVariable int did)
	{
		return service.setDepartmentToCourse(cid,did);
	}
}
