package com.masai.question4;

import java.time.LocalDate;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Embeddable
public class Transaction {
	private int amount;
	@Enumerated(EnumType.STRING)
	private TransactionType type;
	private LocalDate date;

	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Transaction(int amount, TransactionType type, LocalDate date) {
		super();
		this.amount = amount;
		this.type = type;
		this.date = date;
	}

	@Override
	public String toString() {
		return "Transaction [amount=" + amount + ", type=" + type + ", date=" + date + "]";
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public TransactionType getType() {
		return type;
	}

	public void setType(TransactionType type) {
		this.type = type;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

}
