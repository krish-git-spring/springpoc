package com.sb.cassandra.advisor;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.sb.cassandra.exception.InputDataException;
import com.sb.cassandra.exception.RecordNotFoundException;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler
{
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler({RecordNotFoundException.class})
	public ResponseEntity<Object> handleRecordNotFoundException(RecordNotFoundException re)
	{
		ErrorResponse er=null;
		List<String> details=null;
		
		details=new ArrayList<String>();
		details.add(re.getLocalizedMessage());
		er=new ErrorResponse("Record Not Found",details);
		er.setDetails(details);
		return new ResponseEntity<>(er,HttpStatus.NOT_FOUND);
	}
	@ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({InputDataException.class})
	public ResponseEntity<Object> handleInvalidInputException(InputDataException ie)
	{
		ErrorResponse er=null;
		List<String> details=null;
	details=new ArrayList<String>();
		details.add(ie.getLocalizedMessage());
		er=new ErrorResponse("InvalidInput", details);
		return new ResponseEntity<> (er,HttpStatus.BAD_REQUEST);
	}
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) 
	{
		List<String> details=null;
		ErrorResponse errorResponse=null;
		details=new ArrayList<String>();
		for(ObjectError or:ex.getBindingResult().getAllErrors())
		{
			details.add(or.getDefaultMessage());
		}
		errorResponse=new ErrorResponse("Invalid Input", details);
		return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
	}
	
}
