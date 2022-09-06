package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.exception.FlightDoesnotExist;
import com.example.demo.models.Airlines;
import com.example.demo.repository.AirlineRepository;
import com.example.demo.service.AirlineDao;

@SpringBootTest
public class FlightServiceTests 
{
	
	@Autowired
	public AirlineRepository airrepo;
	
	@Autowired
	public AirlineDao airdao;
	
	@Test
	public void getFlightTest() {
		
		//Airlines a1 = airrepo.findById("1").get();
		Airlines a= airrepo.findById("1").get();
		assertThat(a.getFlightno()).isEqualTo("1");
	}
	
	@Test
	public void getAllFlightsTests() throws FlightDoesnotExist
	{
		Airlines a1 = airdao.getFlight("3");
		assertThat(a1.getFlightno()).isEqualTo("3");
	}
}
