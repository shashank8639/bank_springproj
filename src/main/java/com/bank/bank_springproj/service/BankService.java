package com.bank.bank_springproj.service;

import java.util.List;

import com.bank.bank_springproj.repository.BankJDBC;
import com.bank.bank_springproj.repository.MyRepo;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.bank.bank_springproj.model.BankAcc;
import com.bank.bank_springproj.repository.BankRepository;

@Service
public class BankService {

	private final MyRepo bankRepository;

	public BankService(MyRepo myRepo) {
		super();
		this.bankRepository = myRepo;
	}

	public BankAcc registerAcc(BankAcc account) {

		return bankRepository.registerAcc(account);
	}

	public List<BankAcc> getAccounts() {

		return bankRepository.getAccounts();
	}

}
