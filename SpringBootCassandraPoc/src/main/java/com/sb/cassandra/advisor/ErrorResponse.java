package com.sb.cassandra.advisor;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name ="error")
public class ErrorResponse 
{
	public String message;
	public List<String> details;
	public ErrorResponse(String message,List<String> details)
	{
		this.message=message;
		this.details=details;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<String> getDetails() {
		return details;
	}
	public void setDetails(List<String> details) {
		this.details = details;
	}
	

}
