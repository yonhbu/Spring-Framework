package co.com.event.helper.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
public class ResourceNotFoundException  extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException (Class<?> entityClass, Object id) {

		super(String.format("%s was not found for parameter %s", entityClass.getSimpleName(), id));

	}

}
