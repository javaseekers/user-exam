package com.exam.qa.exceptions;

import lombok.Data;

public @Data class ErrorResponse
{
	private String errorMessgae;

	private String exceptionClass;

	ErrorResponse(String errorMsg, Exception ex)
	{
		errorMessgae = errorMsg;
		exceptionClass = ex.toString();
	}
}
