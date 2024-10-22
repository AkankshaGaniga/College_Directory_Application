package org.jsp.cda.exceptionhandler;

import org.jsp.cda.exception.InvalidCourseIdException;
import org.jsp.cda.exception.InvalidCredentialsException;
import org.jsp.cda.exception.InvalidUserIdException;
import org.jsp.cda.exception.NoUsersFoundException;
import org.jsp.cda.responsestructure.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UserExceptionHandler {

	@ExceptionHandler(InvalidCredentialsException.class) // this annotation maps the exception
	public ResponseEntity invalidCredentialsException(InvalidCredentialsException e) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(ResponseStructure.builder().status(HttpStatus.BAD_REQUEST.value())
						.message("Please Check Username or Password...").body(e.getMessage()).build());
	}

	@ExceptionHandler(NoUsersFoundException.class) // this annotation maps the exception
	public ResponseEntity noUsersFoundException(NoUsersFoundException e) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(ResponseStructure.builder().status(HttpStatus.NOT_FOUND.value())
						.message("No Users Found In The Database ...").body(e.getMessage()).build());
	}

	@ExceptionHandler(InvalidUserIdException.class) // this annotation maps the exception
	public ResponseEntity invalidUserIdException(InvalidUserIdException e) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResponseStructure.builder()
				.status(HttpStatus.BAD_REQUEST.value()).message("Invalid User Id ...").body(e.getMessage()).build());
	}
}

//All the requests are redirected to RestController
//All the exceptions are redirected to RestControllerAdvice