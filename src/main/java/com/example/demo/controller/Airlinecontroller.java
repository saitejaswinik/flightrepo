package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.FlightAlreadyExist;
import com.example.demo.exception.FlightDoesnotExist;
import com.example.demo.models.Airlines;
import com.example.demo.repository.AirlineRepository;
import com.example.demo.service.AirlineDao;

@RestController
@CrossOrigin
@RequestMapping("flight/airlines")
public class Airlinecontroller 
{
	@Autowired
	public AirlineRepository airrepo;
	
	@Autowired 
	public AirlineDao airdao;
	
	@PostMapping(value="/create",consumes="application/json;charset = UTF-8")
	public ResponseEntity<?> CreateAirline(@RequestBody Airlines air) throws FlightAlreadyExist
	{
		if(airdao.createAirline(air)!=null)
		{
			return new ResponseEntity<Airlines>(air , HttpStatus.CREATED);
		}
		return new ResponseEntity<String>("sorry , data not inserted",HttpStatus.CONFLICT);
		
/*		try
		{
			airdao.createAirline(air);
			return new ResponseEntity<Airlines>(air , HttpStatus.CREATED);
		}
		catch(FlightAlreadyExist f)
		{
			return new ResponseEntity<String>(f.getMessage(),HttpStatus.CONFLICT);
		}*/
	}
	
	@GetMapping(value="/flightdetails/{flightno}") 
	public ResponseEntity<?> getFlightDetails(@PathVariable("flightno") String flightno ) throws FlightDoesnotExist
	{
		Airlines a1 = airdao.getFlight(flightno);
		if(a1!=null)
			return new ResponseEntity<Airlines>(a1,HttpStatus.OK);
		return new ResponseEntity<String>("flight does not exist",HttpStatus.CONFLICT);
	}

	@GetMapping(value="/flights")
	public ResponseEntity<?> getFlight(@Param("departure") String departure,@Param("arrival") String arrival) throws FlightDoesnotExist
	{
		List<Airlines> a2 = airrepo.getAirlines(departure, arrival);
		if(a2!=null)
		{
			return new ResponseEntity<List<Airlines>>(a2,HttpStatus.OK);
		}
		else
		{
			throw new FlightDoesnotExist();
		}
		//return new ResponseEntity<String>("Flight doesnot exist",HttpStatus.CONFLICT);
	}
}
