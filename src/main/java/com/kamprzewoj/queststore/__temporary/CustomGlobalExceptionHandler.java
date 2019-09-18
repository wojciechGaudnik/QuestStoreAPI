//package com.kamprzewoj.queststore;
//
//import com.kamprzewoj.queststore.api.UserController;
//import lombok.extern.slf4j.Slf4j;
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
//	@Override
//	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
//	                                                              HttpHeaders headers,
//	                                                              HttpStatus status, WebRequest request) {
//
//		Map<String, Object> body = new LinkedHashMap<>();
//		body.put("timestamp", new Date());
//		body.put("status", status.value());
//		log.info("test from --->  CustomGlobalExceptionHandler");
//		//Get all errors
////		List<String> errors = ex.getBindingResult()
////				.getFieldErrors()
////				.stream()
////				.map(x -> x.getDefaultMessage())
////				.collect(Collectors.toList());
////		body.put("errors", errors);
//		return new ResponseEntity<>(body, headers, status);
//	}
//
//
//
//}
//