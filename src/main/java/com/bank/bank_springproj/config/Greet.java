package com.bank.bank_springproj.config;

public class Greet {

	String wish;

	public Greet(String wish) {
		super();
		this.wish = wish;
	}
	
	public void greet(String name) {

		System.out.println("Hello "+name);
		System.out.println(this.wish);
	}
}
