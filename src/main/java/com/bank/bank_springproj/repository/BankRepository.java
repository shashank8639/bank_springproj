package com.bank.bank_springproj.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.bank.bank_springproj.model.BankAcc;

@Repository
public class BankRepository {

	private List<BankAcc> accounts = new ArrayList<>();
	
	public BankAcc registerAcc(BankAcc account) {

		accounts.add(account);
		
		return account;
	}

	public List<BankAcc> getAccounts() {

		return accounts;
	}

}
