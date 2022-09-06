package com.example.demo.models;

import org.springframework.data.annotation.Id;

public class Airlines 
{
	
	@Id
	public String flightno;
	public String name;
	public String datetime;
	public String departure;
	public String arrival;
	public String triptype;
	public double price;
	
	public Airlines()
	{
		
	}

	public Airlines(String flightno, String name, String datetime, String departure, String arrival, String triptype,
			double price) {
		super();
		this.flightno = flightno;
		this.name = name;
		this.datetime = datetime;
		this.departure = departure;
		this.arrival = arrival;
		this.triptype = triptype;
		this.price = price;
	}

	public String getFlightno() {
		return flightno;
	}

	public void setFlightno(String flightno) {
		this.flightno = flightno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDatetime() {
		return datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

	public String getDeparture() {
		return departure;
	}

	public void setDeparture(String departure) {
		this.departure = departure;
	}

	public String getArrival() {
		return arrival;
	}

	public void setArrival(String arrival) {
		this.arrival = arrival;
	}

	public String getTriptype() {
		return triptype;
	}

	public void setArrivaltype(String triptype) {
		this.triptype = triptype;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Airlines [flightno=" + flightno + ", name=" + name + ", datetime=" + datetime + ", departure="
				+ departure + ", arrival=" + arrival + ", arrivaltype=" + triptype + ", price=" + price + "]";
	}
	
	
	
}
