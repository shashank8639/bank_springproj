package com.bank.bank_springproj.service;

import org.springframework.stereotype.Service;

import com.bank.bank_springproj.config.MailProperties;

@Service
public class MailService {

	private final MailProperties mailProperties;

	public MailService(MailProperties mailProperties) {
		super();
		System.out.println("Mail services ");
		System.out.println("host: "+mailProperties.getHostName());
		this.mailProperties = mailProperties;
	}
	
	public void printMailConfig() {

		System.out.println("Host: "+mailProperties.getHostName());
		System.out.println("Port: "+mailProperties.getPort());
		System.out.println("from: "+mailProperties.getFrom());
	}
}
