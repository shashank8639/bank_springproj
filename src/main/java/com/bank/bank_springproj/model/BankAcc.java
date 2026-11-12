package com.bank.bank_springproj.model;

public class BankAcc {

	private long id;
	private String accHolder;
	private double balance;
	
	private String penaltyStatus;
	private double penalizedAmount;

	public BankAcc() {

	}
	public BankAcc(long id, String accHolder, double balance, String penaltyStatus) {
		super();
		this.id = id;
		this.accHolder = accHolder;
		this.balance = balance;
		this.penaltyStatus = penaltyStatus;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAccHolder() {
		return accHolder;
	}

	public void setAccHolder(String accHolder) {
		this.accHolder = accHolder;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getPenaltyStatus() {
		return penaltyStatus;
	}

	public void setPenaltyStatus(String penaltyStatus) {
		this.penaltyStatus = penaltyStatus;
	}
	
}
