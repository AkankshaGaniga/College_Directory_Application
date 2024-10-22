package org.jsp.cda.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.jsp.cda.dao.UserDao;
import org.jsp.cda.entity.Student;
import org.jsp.cda.entity.User;
import org.jsp.cda.exception.InvalidCredentialsException;
import org.jsp.cda.exception.InvalidUserIdException;
import org.jsp.cda.exception.NoUsersFoundException;
import org.jsp.cda.responsestructure.ResponseStructure;
import org.jsp.cda.service.UserService;
import org.jsp.cda.util.AuthorizeUser;
import org.jsp.cda.util.UserStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public ResponseEntity<?> saveUser(User user) {
		user.setStatus(UserStatus.IN_ACTIVE);
		user = userDao.saveUser(user);

		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
				.message("User Saved Successfully...").body(user).build());
	}

	@Override
	public ResponseEntity<?> login(AuthorizeUser authUser) {

		Optional<User> optional = userDao.findByUsernameAndPassword(authUser.getUsername(), authUser.getPassword());

		if (optional.isEmpty())
			throw InvalidCredentialsException.builder().message("Invlalid username or password...").build();
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
				.message("User Verification Successfull...").body(optional.get()).build());
	}

	@Override
	public ResponseEntity<?> findUserById(int uid) {
		Optional<User> optional = userDao.findUserById(uid);
		if (optional.isEmpty())
			throw InvalidUserIdException.builder().message("Invalid User Id...Couldn't Find User").build();
		User user = optional.get();
		return ResponseEntity.status(HttpStatus.FOUND).body(ResponseStructure.builder().status(HttpStatus.FOUND.value())
				.message("User Found Successfully...").body(user).build());
	}

	@Override
	public ResponseEntity<?> findAllUsers() {
		List<User> ul=userDao.findAllUsers();
		if(ul.isEmpty())
			throw NoUsersFoundException.builder().message("No Users Found...").build();
		return ResponseEntity.status(HttpStatus.FOUND).body(ResponseStructure.builder().status(HttpStatus.FOUND.value())
				.message("Users Found Successfully...").body(ul).build());
	}

	@Override
	public ResponseEntity<?> setUserStatusToActive(int uid) {
		Optional<User> optional = userDao.findUserById(uid);
		if(optional.isEmpty())
			throw InvalidUserIdException.builder().message("Invalid User Id...Couldn't Set User Status...").build();
		User user=optional.get();
		user.setStatus(UserStatus.ACTIVE);
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
				.message("User Status Set To ACTIVE Successfully...").body(user).build());
	}

}
