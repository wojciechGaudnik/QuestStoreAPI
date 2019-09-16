//package com.kamprzewoj.queststore;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.core.Ordered;
//import org.springframework.core.annotation.Order;
//import org.springframework.dao.DataIntegrityViolationException;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.http.converter.HttpMessageNotReadableException;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.context.request.WebRequest;
//import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
//
//@Slf4j(topic = "----------> RestExceptionHandler")
//@Order(Ordered.HIGHEST_PRECEDENCE)
//@ControllerAdvice
//public class RestExceptionHandler extends ResponseEntityExceptionHandler {
//
//	@Override
//	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
//		log.error("myyy");
//		String error = "Malformed JSON request";
//		return new ResponseEntity<>( HttpStatus.BAD_REQUEST);
//	}
//
//
//
////	private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
////		return new ResponseEntity<>(apiError, apiError.getStatus());
////	}
//
//
//	@ExceptionHandler(DataIntegrityViolationException.class)
//	public void conflict(DataIntegrityViolationException e) {
//		log.error(e.getLocalizedMessage());
//		log.info(e.toString());
//	}
//
//}
