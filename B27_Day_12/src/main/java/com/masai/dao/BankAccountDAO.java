package com.masai.dao;

import com.masai.dto.BankAccount;
import com.masai.exceptions.NorecordsFoundException;
import com.masai.exceptions.SomethingWentWrongException;

public interface BankAccountDAO {
	public String createAccount(BankAccount acc) throws SomethingWentWrongException;

	public void deposit(int id, int amt) throws SomethingWentWrongException, NorecordsFoundException;

	public void withdraw(int id, int amt) throws SomethingWentWrongException, NorecordsFoundException;

	public BankAccount getAccountById(int id) throws SomethingWentWrongException, NorecordsFoundException;

	public String transferFunds(int sourceId, int destinationId, int amt)
			throws SomethingWentWrongException, NorecordsFoundException;
}
