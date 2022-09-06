package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.FlightDoesnotExist;
import com.example.demo.models.Airlines;
import com.example.demo.models.Booking;
import com.example.demo.repository.BookingRepository;
import com.example.demo.service.BookingDao;

@RestController
@CrossOrigin
@RequestMapping("/flight/ticket")
public class BookingController 
{
	@Autowired
	public BookingRepository bookrepo;
	
	@Autowired
	public BookingDao bookdao;
	
	@PostMapping(value="/create",consumes="application/json;charset = UTF-8")
	public ResponseEntity<?> bookTicket(@RequestBody Booking b)
	{

		if(bookdao.bookticket(b)!=null)
		{
			return new ResponseEntity<Booking>(b , HttpStatus.CREATED);
		}
		
		return new ResponseEntity<String>("Sorry data not inserted",HttpStatus.CONFLICT);
	}
	
	@GetMapping(value = "/getTicketpnr/{pnr}")
	public ResponseEntity<?> getTicket(@PathVariable("pnr") int pnr) throws FlightDoesnotExist
	{
		Booking b1 = bookrepo.getTicketbyPnr(pnr);
		if(b1!=null)
		{
			return new ResponseEntity<Booking>(b1,HttpStatus.OK);
		}
		return new ResponseEntity<String>("Ticket doesn't exist",HttpStatus.CONFLICT);
	}
	 
	@GetMapping(value = "/getTicket/{email}")
	public ResponseEntity<?> getTicketByEmail(@PathVariable("email") String email)
	{
		Booking b2 = bookrepo.getTicketByEmail(email);
		if(b2!=null)
		{
			return new ResponseEntity<Booking>(b2,HttpStatus.OK);
		}
		return new ResponseEntity<String>("Ticket doesn't exist",HttpStatus.CONFLICT);
	}
	
	@DeleteMapping(value="/deleteticket/{booking_id}")
	public ResponseEntity<Map<String,Boolean>> deleteticket(@PathVariable("booking_id") int booking_id)
	{
		bookrepo.deleteById(booking_id);
		Map<String,Boolean> response = new HashMap();
		response.put("Canceled", true);
		return ResponseEntity.ok(response);
	}

}
