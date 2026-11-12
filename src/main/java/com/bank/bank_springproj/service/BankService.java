package com.bank.bank_springproj.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bank.bank_springproj.model.BankAcc;
import com.bank.bank_springproj.repository.BankRepository;

@Service
public class BankService {

	private BankRepository bankRepository;

	public BankService(BankRepository bankRepository) {
		super();
		this.bankRepository = bankRepository;
	}

	public BankAcc registerAcc(BankAcc account) {

		return bankRepository.registerAcc(account);
	}

	public List<BankAcc> getAccounts() {

		return bankRepository.getAccounts();
	}

}
