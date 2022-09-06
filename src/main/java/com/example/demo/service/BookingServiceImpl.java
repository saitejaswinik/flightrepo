package com.example.demo.service;

import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.FlightDoesnotExist;
import com.example.demo.models.Airlines;
import com.example.demo.models.Booking;
import com.example.demo.repository.BookingRepository;

@Service
public class BookingServiceImpl implements BookingDao
{
	
	@Autowired
	public BookingRepository bookrepo;

	@Override
	public String bookticket(Booking b) {
		
		Optional <Booking> optional = bookrepo.findById(b.getBooking_Id());
		if(optional.isEmpty())
		{
			//b.setPnr((int)Math.random());
			bookrepo.save(b);
			return "Flight ticket booked Successfully";
		}
		else
		{
			return null;
		}
		
	}

	@Override
	public Booking getTicket(int pnr) throws FlightDoesnotExist {
		
		Optional <Booking> optional = bookrepo.findById(pnr);
		Booking b1 = bookrepo.findById(pnr).get();
		if(optional.isPresent())
			return b1;
		else
		{
			throw new FlightDoesnotExist();
		}
		
	}

}
