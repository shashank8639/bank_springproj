package com.bank.bank_springproj.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataConfig {

	@Bean
	public String getName() {  // getName
		
		return new String("The string class is just demo for inbuilt class for @Bean");
	}
	
	@Bean
	public Greet getGreet() {  

		return new Greet("Hope you're doing good, nice to meet you.");
	}
	
}
