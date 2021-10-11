package co.com.event.helper.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ValidType extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	public ValidType (String message) {
	    super(message);
	  }
	
}