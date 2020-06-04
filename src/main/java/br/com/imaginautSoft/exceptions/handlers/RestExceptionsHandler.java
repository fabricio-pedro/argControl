package br.com.imaginautSoft.exceptions.handlers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import br.com.imaginautSoft.exceptions.ResourceException;
import br.com.imaginautSoft.exceptions.JsonError;

@ControllerAdvice
public class RestExceptionsHandler {
  
	  @ExceptionHandler
	  public ResponseEntity<JsonError> handleNumberFormatException(HttpServletRequest req,Exception e){
		 String errorURL=req.getRequestURL().toString();
		 System.out.println("Essa exceção e: "+ (e instanceof NumberFormatException));
		 if ( e instanceof MethodArgumentTypeMismatchException) {
		  return new ResponseEntity<>(new  JsonError(errorURL," o id informado está no formato inválido, nao é permito letras!"),HttpStatus.BAD_REQUEST); 	
	  }else { 
		return new ResponseEntity<>(new  JsonError(errorURL,
		           "Unexpected Exception: " + e.getMessage()),
		           HttpStatus.INTERNAL_SERVER_ERROR);	
	  }
	 }
	
	  @ExceptionHandler(ResourceException.class)
	  @ResponseBody
	  public ResponseEntity<JsonError> handleException(HttpServletRequest req, ResourceException ex){
		  String errorUrl=req.getRequestURL().toString(); 
	    	return new ResponseEntity<>(new JsonError(errorUrl, ex.getMessage()), ex.getStatus());
	   }
	      
		  
	  
	      
	    
	      
	
	
  
	
}
