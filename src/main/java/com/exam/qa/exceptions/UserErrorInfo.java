package com.exam.qa.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserErrorInfo extends RuntimeException
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserErrorInfo(String errorKey)
	{
		super(errorKey);

	}

}
