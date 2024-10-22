package org.jsp.cda.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.cda.entity.Department;

public interface DepartmentDao {

	Department saveDepartment(Department dept);

	Optional<Department> findById(int id);

	List<Department> findAll();



}