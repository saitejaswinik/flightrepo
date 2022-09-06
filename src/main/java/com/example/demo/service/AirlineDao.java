package com.example.demo.service;

import com.example.demo.exception.FlightAlreadyExist;
import com.example.demo.exception.FlightDoesnotExist;
import com.example.demo.models.Airlines;

public interface AirlineDao 
{
	public Airlines createAirline(Airlines airline) throws FlightAlreadyExist;
	public Airlines getFlight(String flightno) throws FlightDoesnotExist;
}
