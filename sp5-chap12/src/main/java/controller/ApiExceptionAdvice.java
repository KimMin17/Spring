package controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import spring.MemberNotFoundException;

@RestController("controller")
public class ApiExceptionAdvice {
	
	@ExceptionHandler(MemberNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleNoDate() {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse("no Member"));
	}
}
