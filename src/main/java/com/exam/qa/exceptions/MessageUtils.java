package com.exam.qa.exceptions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
@Component
@PropertySource("classpath:/validationseed.properties")
public class MessageUtils
{
	@Autowired
	private Environment env;

	public String getMessage(String errorKey)
	{
		return env.getProperty(errorKey);
	}

}
