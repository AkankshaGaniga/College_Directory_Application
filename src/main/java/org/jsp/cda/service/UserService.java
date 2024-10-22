package org.jsp.cda.service;

import org.jsp.cda.entity.User;
import org.jsp.cda.util.AuthorizeUser;
import org.springframework.http.ResponseEntity;

public interface UserService {

	ResponseEntity<?> saveUser(User user);

	ResponseEntity<?> login(AuthorizeUser authUser);

	ResponseEntity<?> findUserById(int uid);

	ResponseEntity<?> findAllUsers();

	ResponseEntity<?> setUserStatusToActive(int uid);

}
