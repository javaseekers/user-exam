package com.exam.qa.exceptions;

public class ExcelDataImport extends RuntimeException
{

	public ExcelDataImport(String errorkey)
	{
		super(errorkey);
	}

}
