package com.example.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.models.Airlines;

public interface AirlineRepository extends MongoRepository<Airlines, String>
{

	@Query("{departure:?0,arrival:?1}")
	public List<Airlines> getAirlines(@Param("departure") String departure,@Param("arrival") String arrival);
}
