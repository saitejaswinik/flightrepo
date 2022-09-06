package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.example.demo.exception.FlightAlreadyExist;
import com.example.demo.exception.FlightDoesnotExist;
import com.example.demo.models.Airlines;
import com.example.demo.repository.AirlineRepository;

@Service
public class AirlineServiceImpl implements AirlineDao{

	@Autowired 
	public AirlineRepository airrepo;
	
	@Override
	public Airlines createAirline(Airlines airline) throws FlightAlreadyExist {
		
		Optional <Airlines> optional = airrepo.findById(airline.getFlightno());
		
		if(optional.isPresent())
		{
			throw new FlightAlreadyExist();
		}
			return airrepo.save(airline);
	}
	
	/*@KafkaListener(topics="javamc",groupId="mygroup")
	public void consumefromTopic(String message)
	{
		System.out.println("consumed message is :"+message);
	}
*/
	@Override
	public Airlines getFlight(String flightno) throws FlightDoesnotExist {
		
		Optional <Airlines> optional = airrepo.findById(flightno);
		Airlines a1 = airrepo.findById(flightno).get();
		if(optional.isPresent())
		{
			return a1;
		}
		else
		{
			throw new FlightDoesnotExist();
		}
		
	}

}
