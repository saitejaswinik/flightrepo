package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.models.Booking;
import com.example.demo.repository.BookingRepository;
import com.example.demo.service.BookingDao;

@SpringBootTest
public class BookingServiceTests 
{
	@Autowired
	public BookingRepository bookrepo;
	
	@Autowired
	public BookingDao bookdao;
	
	@Test
	public void getTicketTest()
	{
		Booking b = bookrepo.getTicketByEmail("vinay@gmail.com");
		assertThat(b.getEmail()).isEqualTo("vinay@gmail.com");
	}
	
	
	
}
