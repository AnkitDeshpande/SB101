package com.masai.services;

import com.masai.dao.BankAccountDAO;
import com.masai.dao.BankAccountDAOJdbcImpl;
import com.masai.dto.BankAccount;
import com.masai.exceptions.NorecordsFoundException;
import com.masai.exceptions.SomethingWentWrongException;

public class BankaccServImpl implements BankAccountService {

	@Override
	public String createAccount(BankAccount acc) throws SomethingWentWrongException {
		BankAccountDAO bad = new BankAccountDAOJdbcImpl();
		return bad.createAccount(acc);
	}

	@Override
	public void deposit(int id, int amt) throws SomethingWentWrongException, NorecordsFoundException {
		BankAccountDAO bad = new BankAccountDAOJdbcImpl();
		bad.deposit(id, amt);
	}

	@Override
	public void withdraw(int id, int amt) throws SomethingWentWrongException, NorecordsFoundException {
		BankAccountDAO bad = new BankAccountDAOJdbcImpl();
		bad.withdraw(id, amt);
	}

	@Override
	public BankAccount getAccountById(int id) throws SomethingWentWrongException, NorecordsFoundException {
		BankAccountDAO bad = new BankAccountDAOJdbcImpl();
		return bad.getAccountById(id);
	}

	@Override
	public String transferFunds(int sourceId, int destinationId, int amt)
			throws SomethingWentWrongException, NorecordsFoundException {
		BankAccountDAO bad = new BankAccountDAOJdbcImpl();
		return bad.transferFunds(sourceId, destinationId, amt);
	}

}
