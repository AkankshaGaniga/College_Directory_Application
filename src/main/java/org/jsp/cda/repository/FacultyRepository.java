package org.jsp.cda.repository;

import org.jsp.cda.entity.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface FacultyRepository extends JpaRepository<Faculty, Integer> {

}
