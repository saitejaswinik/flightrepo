/*package com.example.demo.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@RequestMapping("/jwt/admin")
public class AuthenticationController 
{
	private Map<String,String> map = new HashMap<String,String>();
	
	public String generateToken(String username,String password) throws ServletException,Exception
	{
		String jwttoken = "";
		if(username == null || password == null)
		{
			throw new ServletException("please provide valid username and password");
		}
		
		jwttoken = Jwts.builder().setSubject(username).setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis()+30000000))
				.signWith(SignatureAlgorithm.HS256, "secret key").compact();
		
		
		return jwttoken;
	}
	
	@GetMapping("/hello")
	public String helloworld()
	{
		return "welcome ";
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> doLogin(@RequestParam String username,@RequestParam String password)
	{
		System.out.println(username);
		try 
		{
			String token = generateToken("demo","demo@123");
			System.out.println(token);
			map.put("message","admin has logged in");
			map.put("token", token);
		}
		catch(Exception e)
		{
			System.out.println(e);
			map.put("message", e.getMessage());
			map.put("token", null);
			return new ResponseEntity<>(map,HttpStatus.UNAUTHORIZED);
		}
		return new ResponseEntity<>(map,HttpStatus.OK);
	}
}*/
