package com.demo.bs.project.controller.advice;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(basePackages = {"com.demo.bs.project.controller.*"})
public class ExceptionControllerAdvice {

	/*@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<Player> exception(HttpMessageNotReadableException e){
		
	}*/
	
}
