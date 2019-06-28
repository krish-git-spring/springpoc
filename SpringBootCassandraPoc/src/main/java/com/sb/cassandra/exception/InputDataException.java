package com.sb.cassandra.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InputDataException extends RuntimeException
{
	public InputDataException(String exception)
	{
		super(exception);
	}

}
