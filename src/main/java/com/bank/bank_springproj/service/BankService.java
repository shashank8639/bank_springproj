package com.bank.bank_springproj.service;

import java.util.List;

import com.bank.bank_springproj.repository.BankJDBC;
import com.bank.bank_springproj.repository.MyRepo;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.bank.bank_springproj.model.BankAcc;
import com.bank.bank_springproj.repository.BankRepository;

@Service
public class BankService {

	private final MyRepo bankRepository;

	@Value("${bank.branch.name}")
	private String bankName;


	public BankService( MyRepo myRepo) {
		super();
		System.out.println("Bank name: "+this.bankName);
		System.out.println("1. Bank Service is instantiated");
		this.bankRepository = myRepo;
	}

	@PostConstruct
	public void loadResources() {
		System.out.println("Bank name: "+this.bankName);
		System.out.println("3. Open connection from port: 4545 and connect to: 8080");
	}



	public BankAcc registerAcc(BankAcc account) {

		return bankRepository.registerAcc(account);
	}

	public List<BankAcc> getAccounts() {
		System.out.println("4. accessed data");
		return bankRepository.getAccounts();
	}

	@PreDestroy
	public void close() {
		System.out.println("Cache systems the data is removed");
		System.out.println("5.Close the connections and destroy bean,then shutdown.");
	}

}
