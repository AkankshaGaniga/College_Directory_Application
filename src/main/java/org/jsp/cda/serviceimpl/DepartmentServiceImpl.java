package org.jsp.cda.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.jsp.cda.dao.DepartmentDao;
import org.jsp.cda.entity.Department;
import org.jsp.cda.entity.User;
import org.jsp.cda.exception.InvalidDepartmentIdException;
import org.jsp.cda.exception.NoDepartmentsFoundexception;
import org.jsp.cda.responsestructure.ResponseStructure;
import org.jsp.cda.service.DepartmentService;
import org.jsp.cda.util.UserStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentDao deptDao;

	@Override
	public ResponseEntity<?> saveDepartment(Department dept) {
		dept = deptDao.saveDepartment(dept);
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
				.message("Department Saved Successfully...").body(dept).build());
	}

	@Override
	public ResponseEntity<?> findById(int id) {
		Optional<Department> optional = deptDao.findById(id);
		if(optional.isEmpty())
			throw InvalidDepartmentIdException.builder().message("Invalid Department Id...").build();
		return ResponseEntity.status(HttpStatus.FOUND).body(ResponseStructure.builder().status(HttpStatus.FOUND.value())
				.message("Department Found Successfully...").body(optional).build());
	}

	@Override
	public ResponseEntity<?> findAll() {
		List<Department> dl = deptDao.findAll();
		if(dl.isEmpty())
			throw NoDepartmentsFoundexception.builder().message("No Departments Found...").build();
		return ResponseEntity.status(HttpStatus.FOUND).body(ResponseStructure.builder().status(HttpStatus.FOUND.value())
				.message("All Departments Fetched Successfully...").body(dl).build());
	}
}
