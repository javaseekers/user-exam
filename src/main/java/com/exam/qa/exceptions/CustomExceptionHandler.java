package com.exam.qa.exceptions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler
{
	@Autowired
	private MessageUtils messageUtils;

	@ExceptionHandler({UserErrorInfo.class})
	public ResponseEntity<ErrorResponse> handleDogsServiceException(
		UserErrorInfo e)
	{
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
			.body(new ErrorResponse(
				messageUtils.getMessage(e.getMessage()),
				e));
	}
	@ExceptionHandler({Exception.class})
	public ResponseEntity<ErrorResponse> comanException(Exception e)
	{
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
			.body(new ErrorResponse(
				messageUtils.getMessage(e.getMessage()),
				e));
	}
}
