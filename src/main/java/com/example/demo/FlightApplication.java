package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
//import com.example.demo.filter.JwtFilter;

@SpringBootApplication
//@EnableDiscoveryClient
public class FlightApplication {
	
	/*@Bean
	public FilterRegistrationBean jwt()
	{
		FilterRegistrationBean fb = new FilterRegistrationBean();
		fb.setFilter(new JwtFilter());
		fb.addUrlPatterns("/flight/airlines/create");
		return fb;
	}*/

	public static void main(String[] args) {
		SpringApplication.run(FlightApplication.class, args);
	}

}
