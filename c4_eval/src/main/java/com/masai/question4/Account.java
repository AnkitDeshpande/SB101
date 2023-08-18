package com.masai.question4;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OrderBy;

@Entity
public class Account {
	@Id
	private String acc_no;
	@Enumerated(EnumType.STRING)
	private AccountType type;
	private String bank_name;
	private String branch_name;
	@Embedded
	@ElementCollection(fetch = FetchType.EAGER)
	@OrderBy("amount desc")
	private Set<Transaction> transactionSet;

	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Account(String acc_no, AccountType type, String bank_name, String branch_name,
			Set<Transaction> transactionSet) {
		super();
		this.acc_no = acc_no;
		this.type = type;
		this.bank_name = bank_name;
		this.branch_name = branch_name;
		this.transactionSet = transactionSet;
	}

	public String getAcc_no() {
		return acc_no;
	}

	public void setAcc_no(String acc_no) {
		this.acc_no = acc_no;
	}

	public AccountType getType() {
		return type;
	}

	public void setType(AccountType type) {
		this.type = type;
	}

	public String getBank_name() {
		return bank_name;
	}

	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}

	public String getBranch_name() {
		return branch_name;
	}

	public void setBranch_name(String branch_name) {
		this.branch_name = branch_name;
	}

	public Set<Transaction> getTransactionSet() {
		return transactionSet;
	}

	public void setTransactionSet(Set<Transaction> transactionSet) {
		this.transactionSet = transactionSet;
	}

	@Override
	public String toString() {
		return "Account [acc_no=" + acc_no + ", type=" + type + ", bank_name=" + bank_name + ", branch_name="
				+ branch_name + ", transactionSet=" + transactionSet + "]";
	}

}
