package org.jsp.cda.controller;

import org.jsp.cda.entity.Department;
import org.jsp.cda.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/departments")
@RestController
public class DepartmentController {
     
	@Autowired
	private DepartmentService service;
	
	@PostMapping
	public ResponseEntity<?> saveDepartment(@RequestBody Department dept)
	{
		return service.saveDepartment(dept);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> findDepartmentById(@PathVariable int id)
	{
		return service.findById(id);
	}
	
	@GetMapping
	public ResponseEntity<?> findAllDepartments()
	{
		return service.findAll();
	}
}


