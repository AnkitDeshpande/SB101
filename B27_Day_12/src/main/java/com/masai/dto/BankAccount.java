package com.masai.dto;

public class BankAccount {
	private int id;
	private String accountNumber;
	private double balance;

	public BankAccount() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BankAccount(int id, String accountNumber, double balance) {
		super();
		this.id = id;
		this.accountNumber = accountNumber;
		this.balance = balance;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "BankAccount [id=" + id + ", accountNumber=" + accountNumber + ", balance=" + balance + "]";
	}

}
