package br.com.imaginautSoft.exceptions;

import org.springframework.http.HttpStatus;

public class ResourceException extends RuntimeException {
 
 private HttpStatus status;
 
 public ResourceException(String msg){
	super(msg); 
	 
 }
 public ResourceException(HttpStatus st, String msg){
	super(msg);
	this.status=st;
	
	
}
 ResourceException(HttpStatus status,Throwable cause) {
    super(cause);
    this.status = status;
}
ResourceException(String msg,Throwable cause) {
	    super(msg,cause);
	    
}
public HttpStatus getStatus() {
	return status;
}
public String errorMessage() {
	return status.value()+ ":".concat(getMessage());
}
	 
	
	
}