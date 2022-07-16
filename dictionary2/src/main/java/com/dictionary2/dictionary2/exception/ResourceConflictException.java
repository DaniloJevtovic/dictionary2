package com.dictionary2.dictionary2.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResourceConflictException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String resourceId;

	public ResourceConflictException(String string, String message) {
		super(message);
		this.setResourceId(string);
	}

}
