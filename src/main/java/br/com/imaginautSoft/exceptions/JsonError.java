package br.com.imaginautSoft.exceptions;

public class JsonError {
 private String url;
 private String message;

 
 public JsonError(String url, String message) {
	super();
	this.url = url;
	this.message = message;
}
public String getUrl() {
	return url;
}
public String getMessage() {
	return message;
}
public void setUrl(String url) {
	this.url = url;
}
public void setMessage(String message) {
	this.message = message;
}
 
 
 
	
}
