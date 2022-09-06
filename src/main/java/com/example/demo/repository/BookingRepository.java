package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.models.Booking;

public interface BookingRepository extends MongoRepository<Booking, Integer>
{

	@Query("{pnr:?0}")
	public Booking getTicketbyPnr(@Param("pnr") int pnr);
	
	@Query("{email:?0}")
	public Booking getTicketByEmail(@Param("email") String email);
	
}
