package com.kamprzewoj.queststore.errorHandlers;

import com.kamprzewoj.queststore.tools.ConsoleColors;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {

//	@ExceptionHandler(value = {Exception.class})
	@ExceptionHandler(value = {NullPointerException.class})
	public ResponseEntity<Object> handleNullPointerException(NullPointerException e, WebRequest request) {
		String errorMessage = e.getLocalizedMessage();
		logger.error(ConsoleColors.RED + request + " <--------- request"+ ConsoleColors.RESET);
		if(errorMessage == null) errorMessage = e.toString();
		return new ResponseEntity<>(
				errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR
		);
	}
}
































//todo -----------------------------------------------------------------------------------------------------------------------
//
////import com.kamprzewoj.queststore.api.UserController;
//import lombok.extern.slf4j.Slf4j;
//import org.hibernate.exception.ConstraintViolationException;
//import org.springframework.dao.DataIntegrityViolationException;
//import org.springframework.dao.EmptyResultDataAccessException;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.MethodArgumentNotValidException;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.context.request.WebRequest;
//import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
//
//import java.util.Date;
//import java.util.LinkedHashMap;
//import java.util.Map;
//
//@Slf4j(topic = "CustomGlobalExceptionHandler --->")
//@ControllerAdvice
//public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {
//
////	@Override
////	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
////	                                                              HttpHeaders headers,
////	                                                              HttpStatus status, WebRequest request) {
////
////		Map<String, Object> body = new LinkedHashMap<>();
////		body.put("timestamp", new Date());
////		body.put("status", status.value());
////		log.info("test from --->  CustomGlobalExceptionHandler");
////		//Get all errors
//////		List<String> errors = ex.getBindingResult()
//////				.getFieldErrors()
//////				.stream()
//////				.map(x -> x.getDefaultMessage())
//////				.collect(Collectors.toList());
//////		body.put("errors", errors);
////		return new ResponseEntity<>(body, headers, status);
////	}
//
//	@ExceptionHandler(DataIntegrityViolationException.class)
//	public ResponseEntity errorAdd(DataIntegrityViolationException e) {
//		log.error("my catch -------------------------------------------->");
////		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMostSpecificCause().getMessage());
//		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("my catch -------------------------------------------->");
//	}
//
////	@ExceptionHandler(ConstraintViolationException.class)
////	public ResponseEntity error
//
//
////	@ExceptionHandler(PSQLException.)
//
//
////
////	@ExceptionHandler(EmptyResultDataAccessException.class)
////	public ResponseEntity errorDel(EmptyResultDataAccessException e) {
////		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMostSpecificCause().getMessage());
////	}
////
////	@ExceptionHandler(MethodArgumentNotValidException.class)
////	public ResponseEntity errorUpdate(MethodArgumentNotValidException e) {
////		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
////	}
//
//
//}
//
