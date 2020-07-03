package br.com.imaginautSoft.exceptions;

import java.util.ArrayList;
import java.util.List;

public class JsonValidationError extends JsonError{

	private List<FieldMessage> errors=new ArrayList<>();
	
	public JsonValidationError(String url, String message) {
		super(url, message);
		// TODO Auto-generated constructor stub
	}

	public List<FieldMessage> getErrors() {
		return errors;
	}

	public void addError(String fieldName, String message ) {
	 this.errors.add(new FieldMessage(fieldName, message));	
		
	}


}
	


