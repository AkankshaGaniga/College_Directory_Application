package org.jsp.cda.controller;

import org.jsp.cda.entity.User;
import org.jsp.cda.service.UserService;
import org.jsp.cda.util.AuthorizeUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(value = "/users")
public class UserController {

	@Autowired
	private UserService service;

	@PostMapping
	public ResponseEntity<?> saveUser(@RequestBody User user) {
		return service.saveUser(user);
	}

	@PostMapping(value = "/login")
	public ResponseEntity<?> login(@RequestBody AuthorizeUser authUser) {
		return service.login(authUser);
	}

	@GetMapping(value = "/{uid}")
	public ResponseEntity<?> findUserById(@PathVariable int uid) {
		return service.findUserById(uid);
	}

	@GetMapping
	public ResponseEntity<?> findAllUsers() {
		return service.findAllUsers();
	}
	
	@PatchMapping(value = "/{uid}")
	public ResponseEntity<?> setUserStatusToActive(@PathVariable int uid)
	{
		return service.setUserStatusToActive(uid);
	}
}
