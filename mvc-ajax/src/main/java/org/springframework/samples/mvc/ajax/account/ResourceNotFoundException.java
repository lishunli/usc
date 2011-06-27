package org.springframework.samples.mvc.ajax.account;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 4387840534611481596L;
	private Long resourceId;
	
	public ResourceNotFoundException(Long resourceId) {
		this.resourceId = resourceId;
	}
	
	public Long getResourceId() {
		return resourceId;
	}
	
}
