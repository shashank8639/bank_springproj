package com.bank.bank_springproj.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.bank_springproj.model.BankAcc;
import com.bank.bank_springproj.service.BankService;

@RestController
@RequestMapping("/api/accounts")
public class BankController {

	private BankService bankService;
	
	public BankController(BankService bankService) {
		super();
		this.bankService = bankService;
	}

	@PostMapping
	public BankAcc registerAcc(@RequestBody BankAcc account) {
		
		return bankService.registerAcc(account);
	}
	
	@GetMapping
	public List<BankAcc> getAccounts() {

		return bankService.getAccounts();
	}
	
}
