package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.CONFLICT,reason="flight already exist")
public class FlightAlreadyExist extends Exception
{
	String msg;
	public FlightAlreadyExist()
	{
		
	}
	
	public FlightAlreadyExist(String msg)
	{
		super(msg);
		this.msg = msg;
	}
}
