package br.com.imaginautSoft.exceptions.handlers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import br.com.imaginautSoft.exceptions.ResourceException;
import br.com.imaginautSoft.exceptions.DataIntregrityException;
import br.com.imaginautSoft.exceptions.JsonError;
import br.com.imaginautSoft.exceptions.JsonValidationError;
import br.com.imaginautSoft.exceptions.ObjectNotFoundException;

@ControllerAdvice
public class RestExceptionsHandler {
  
	
	  @ExceptionHandler(ObjectNotFoundException.class)
	  @ResponseBody
	  public ResponseEntity<JsonError> handleObjectException(HttpServletRequest req, ObjectNotFoundException ex){
		  String errorUrl=req.getRequestURL().toString(); 
		   JsonError jsonError=new JsonError(errorUrl, ex.getMessage());
	    	return ResponseEntity.status(HttpStatus.NOT_FOUND).body(jsonError);
	   }

	  @ExceptionHandler(DataIntregrityException.class)
	  @ResponseBody
	  public ResponseEntity<JsonError> handleDataIntegratyException(HttpServletRequest req, DataIntregrityException ex){
	       String errorUrl=req.getRequestURL().toString(); 
		   JsonError jsonError=new JsonError(errorUrl, ex.getMessage());
	    	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonError);
	   }   
		  
	  @ExceptionHandler(MethodArgumentNotValidException.class)
	  @ResponseBody
	  public ResponseEntity<JsonValidationError> handleValidationsErros(HttpServletRequest req, MethodArgumentNotValidException ex){
	       String errorUrl=req.getRequestURL().toString(); 
		   JsonValidationError errors=new JsonValidationError(errorUrl, "Erros de validação"); 
	       for (FieldError e: ex.getBindingResult().getFieldErrors() ) {
	    	   errors.addError(e.getField(), e.getDefaultMessage());
	       }
	       
	    	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
	   }   
		  
	      
	    
	      
	
	
  
	
}
