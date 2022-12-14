package com.example.demo.models;

import org.springframework.data.annotation.Id;

public class Passenger 
{
	
	@Id
	public String id;
	public String name;
	public String gender;
	public String age;
	
	public Passenger()
	{
		
	}

	public String getId()
	{
		return id;
	}
	
	public void setId(String id)
	{
		this.id=id;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public Passenger(String id,String name, String gender, String age) {
		super();
		this.id=id;
		this.name = name;
		this.gender = gender;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Passenger [name=" + name + ", gender=" + gender + ", age=" + age + "]";
	}
	
	
	
	
}
