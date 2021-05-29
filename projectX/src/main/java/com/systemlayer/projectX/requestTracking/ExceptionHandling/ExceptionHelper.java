package com.systemlayer.projectX.requestTracking.ExceptionHandling;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.systemlayer.projectX.requestTracking.model.Response;

@ControllerAdvice
public class ExceptionHelper extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(value= {DataAccessException.class})
	public ResponseEntity<Object> hanResponseEntity(DataAccessException ex){
		Response response = new Response();
		response.setSuccess(false);
	return new ResponseEntity<Object>(response,HttpStatus.CONFLICT);
	}
	@ExceptionHandler(value= {Exception.class})
	public ResponseEntity<Object> hanResponseEntity(Exception ex){
		Response response = new Response();
		response.setSuccess(false);
	return new ResponseEntity<Object>(response,HttpStatus.BAD_REQUEST);
	}
}
