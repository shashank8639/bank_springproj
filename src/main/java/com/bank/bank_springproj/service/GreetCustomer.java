package com.bank.bank_springproj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.bank_springproj.config.Greet;

@Service
public class GreetCustomer {

	private Greet greet;  // we need Greet object
	private String value;
	
	public GreetCustomer(Greet greet, String value) {
		super();
		this.greet = greet;
		this.value = value;
	}


	public void wishCustomer() {
		
		greet.greet("Shashank");
		System.out.println(this.value);
	}
}
