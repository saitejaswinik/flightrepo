package com.example.demo.service;

import com.example.demo.exception.FlightDoesnotExist;
import com.example.demo.models.Booking;

public interface BookingDao 
{
	public String bookticket(Booking b);
	
	public Booking getTicket(int pnr) throws FlightDoesnotExist;
}
