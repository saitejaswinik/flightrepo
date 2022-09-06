package com.example.demo.models;

import java.util.ArrayList;
import java.util.List;


import org.springframework.data.annotation.Id;


public class Booking {

	@Id
	public int booking_id;
	public int pnr;
	public String name;
	public String email;
	public String mealtype;
	public Airlines air;
	public List<Passenger> pass = new ArrayList<>();

	public Booking() {

	}

	public Booking(int booking_id, int pnr, String name, String email, String mealtype,Airlines air,List<Passenger> pass) {
		super();
		this.booking_id = booking_id;
		this.pnr = pnr;
		this.name = name;
		this.email = email;
		this.mealtype = mealtype;
		this.air=air;
		this.pass= pass;

	}

	public void setBooking_Id(int booking_id) {
		this.booking_id = booking_id;
	}

	public int getBooking_Id() {
		return booking_id;
	}

	public List<Passenger> getPass() {
		return pass;
	}

	public void setPass(List<Passenger> pass) {
		this.pass = pass;
	}

	public int getPnr() {
		return pnr;
	}

	public void setPnr(int pnr) {
		this.pnr = pnr;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMealtype() {
		return mealtype;
	}

	public void setMealtype(String mealtype) {
		this.mealtype = mealtype;
	}

	public Airlines getAir() {
		return air;
	}

	public void setAir(Airlines air) {
		this.air = air;
	}
	
	@Override
	public String toString() {
		return "Booking [pnr=" + pnr + ", name=" + name + ", email=" + email + ", mealtype=" + mealtype + ", air=" + air
				+ "]";
	}

}
