package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.masai.dto.BankAccount;
import com.masai.exceptions.NorecordsFoundException;
import com.masai.exceptions.SomethingWentWrongException;
import com.masai.utility.DB;

public class BankAccountDAOJdbcImpl implements BankAccountDAO {

	@Override
	public String createAccount(BankAccount acc) throws SomethingWentWrongException {
		Connection con = DB.connect();
		String query = "Insert into BankAccount(id, account_number, balance) values (?, ?, ?)";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, acc.getId());
			ps.setString(2, acc.getAccountNumber());
			ps.setDouble(3, acc.getBalance());

			return ps.executeUpdate() > 0 ? "New Account Added." : "Something went wrong, Try again Later.";
		} catch (Exception e) {
			throw new SomethingWentWrongException("Something went wrong, Try again Later.");
		} finally {
			DB.close(con);
		}
	}

	@Override
	public void deposit(int id, int amt) throws SomethingWentWrongException, NorecordsFoundException {
		Connection con = DB.connect();
		String query = "Update BankAccount set balance = balance + ? where id = ?";
		try {
			if (getAccountById(id) != null) {
				PreparedStatement ps = con.prepareStatement(query);
				ps.setInt(1, amt);
				ps.setInt(2, id);

				System.out.println(
						ps.executeUpdate() > 0 ? "Balance Added." : "Cannot Deposit right Now, Try again Later.");
			} else {
				throw new NorecordsFoundException("No Account with id : " + id);
			}
		} catch (Exception e) {
			throw new SomethingWentWrongException("Something went wrong, Try again Later.");
		} finally {
			DB.close(con);
		}
	}

	@Override
	public void withdraw(int id, int amt) throws SomethingWentWrongException, NorecordsFoundException {
		Connection con = DB.connect();
		String query = "Update BankAccount set balance = balance - ? where id = ?";
		try {
			if (getAccountById(id) != null && getAccountById(id).getBalance() > amt) {
				PreparedStatement ps = con.prepareStatement(query);
				ps.setInt(1, amt);
				ps.setInt(2, id);

				System.out.println(
						ps.executeUpdate() > 0 ? "Balance withdrawn." : "Cannot Withdraw right now, Try again Later.");
			} else {
				throw new NorecordsFoundException("No Account with id OR Insufficient Balance");
			}
		} catch (Exception e) {
			throw new SomethingWentWrongException("Something went wrong, Try again Later.");
		} finally {
			DB.close(con);
		}
	}

	@Override
	public BankAccount getAccountById(int id) throws SomethingWentWrongException, NorecordsFoundException {
		Connection con = DB.connect();
		BankAccount acc = null;
		String query = "select * from BankAccount where id = ?";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				acc = new BankAccount();
				acc.setId(rs.getInt(1));
				acc.setAccountNumber(rs.getString(2));
				acc.setBalance(rs.getDouble(3));
				return acc;
			} else {
				throw new NorecordsFoundException("No Account with id : " + id);
			}

		} catch (Exception e) {
			throw new SomethingWentWrongException("Something went wrong, Try again Later.");
		} finally {
			DB.close(con);
		}
	}

	@Override
	public String transferFunds(int sourceId, int destinationId, int amt)
			throws SomethingWentWrongException, NorecordsFoundException {
		Connection con = DB.connect();
		BankAccount source = null;
		BankAccount destination = null;
		String deductQuery = "UPDATE BankAccount SET balance = balance - ? WHERE id = ?";
		String addQuery = "UPDATE BankAccount SET balance = balance + ? WHERE id = ?";
		try {
			con.setAutoCommit(false);
			source = getAccountById(sourceId);
			destination = getAccountById(destinationId);

			if (source != null && destination != null && source.getBalance() > amt) {
				PreparedStatement ps = con.prepareStatement(deductQuery);
				ps.setDouble(1, amt);
				ps.setInt(2, sourceId);
				int rowaffected = ps.executeUpdate();

				ps = con.prepareStatement(addQuery);
				ps.setDouble(1, amt);
				ps.setInt(2, destinationId);
				rowaffected += ps.executeUpdate();

				if (rowaffected < 2) {
					con.rollback();
					return "Something Went wrong";
				} else {
					con.commit();
					return "Balance transferred successfully.";
				}

			} else {
				con.rollback();
				return "Invalid Credentials OR Insufficient Balance.";
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.close(con);
		}
		return null;
	}

}
