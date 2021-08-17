package com.vs.recaudacion.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.vs.recaudacion.config.exception.BadRequestException;
import com.vs.recaudacion.config.exception.NotFoundException;

@ControllerAdvice(annotations = RestController.class)
public class ExceptionConfig {
	
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<?> notFoundException(Exception e){
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		
	}
	
	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<?> badRequestException(Exception e){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
	}

}
