package com.masaischool.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.masaischool.dto.Employee;
import com.masaischool.exception.NoEmployeeFoundException;
import com.masaischool.exception.SomethingWentWrongException;
import com.masaischool.utility.DBUtils;

public class EmployeeDAOImpl implements EmployeeDAO {

	@Override
	public void addEmployee(Employee employee) throws SomethingWentWrongException {
		//Code to take connection
		Connection conn = null;
		try {
			//Create an object of Connection
			conn = DBUtils.createConnection();
			//you are here means connection is successful
			//Create Query
			String insertQuery = "INSERT INTO employee (name, salary, state, joining_date) VALUES (?, ?, ?, ?)";
			//Create a PreparedStatement
			PreparedStatement ps = conn.prepareStatement(insertQuery);
			//stuff the data
			ps.setString(1, employee.getName());
			ps.setDouble(2, employee.getSalary());
			ps.setString(3, employee.getState());
			ps.setDate(4, Date.valueOf(employee.getJoiningDate()));
			
			//DML statement so executeUpdate
			ps.executeUpdate();
		}catch(SQLException ex) {
			//you are here means Something is not okay
			throw new SomethingWentWrongException(ex.getMessage());
		}finally {
			try {
				DBUtils.closeConnection(conn);				
			}catch(SQLException ex) {
				throw new SomethingWentWrongException(ex.getMessage());
			}
		}
	}
	
	@Override
	public void updateEmployee(Employee employee) throws SomethingWentWrongException, NoEmployeeFoundException{
		//Code to take connection
		Connection conn = null;
		try {
			//Create an object of Connection
			conn = DBUtils.createConnection();
			//you are here means connection is successful
			
			//check if the employee for given id exists or not
			String selectQuery = "SELECT count(*) FROM employee WHERE id = ?";
			PreparedStatement ps = conn.prepareStatement(selectQuery);
			ps.setInt(1, employee.getEmployeeId());
			ResultSet resultSet = ps.executeQuery();

			//The result is always before the first record
			//we have to use next() method to take it to first record
			resultSet.next();
			if(resultSet.getInt(1) == 0) {
				//No employee for given id, so throw the exception
				throw new NoEmployeeFoundException("No Employee found for given id " + employee.getEmployeeId());
			}
			
			//you are here means employee exists for given id
			
			//Create Query
			String updateQuery = "UPDATE employee SET name = ?, salary = ?, state = ?, joining_date = ? WHERE id =?";
			//Create a PreparedStatement
			ps = conn.prepareStatement(updateQuery);
			//stuff the data
			ps.setString(1, employee.getName());
			ps.setDouble(2, employee.getSalary());
			ps.setString(3, employee.getState());
			ps.setDate(4, Date.valueOf(employee.getJoiningDate()));
			ps.setInt(5, employee.getEmployeeId());
			
			//DML statement so executeUpdate
			ps.executeUpdate();
		}catch(SQLException ex) {
			//you are here means Something is not okay
			throw new SomethingWentWrongException(ex.getMessage());
		}finally {
			try {
				DBUtils.closeConnection(conn);				
			}catch(SQLException ex) {
				throw new SomethingWentWrongException(ex.getMessage());
			}
		}
	}
	
	@Override
	public void borrowAmount(Integer lenderEmployeeId, Integer borrowerEmployeeId, double amountInLPA) 
			throws SomethingWentWrongException, NoEmployeeFoundException{
		//UPDATE employee SET salary = salary - amountInLPA WHERE id = lenderEmployeeId
		//UPDATE employee SET salary = salary + amountInLPA WHERE id = borrowerEmployeeId
		
		//Code to take connection
		Connection conn = null;
		try {
			//Create an object of Connection
			conn = DBUtils.createConnection();
			//you are here means connection is successful
			
			//check if the employee for given id exists or not
			String selectQuery = "SELECT count(*) FROM employee WHERE id = ? OR id = ?";
			PreparedStatement ps = conn.prepareStatement(selectQuery);
			ps.setInt(1, lenderEmployeeId);
			ps.setInt(2, borrowerEmployeeId);
			ResultSet resultSet = ps.executeQuery();
			
			//The result is always before the first record
			//we have to use next() method to take it to first record
			resultSet.next();
			if(resultSet.getInt(1) < 2) {
				//No employee for given id, so throw the exception
				throw new NoEmployeeFoundException("Invalid employee id for either borrower or lender");
			}
			
			//set the auto commit to false
			conn.setAutoCommit(false);
			String updateQuery = "UPDATE employee SET salary = salary - ? WHERE id = ?";
			ps = conn.prepareStatement(updateQuery);
			ps.setDouble(1, amountInLPA);
			ps.setInt(2, lenderEmployeeId);
			ps.executeUpdate();
			
			//say exception is after first update, it will go to catch block, there transaction will be rollbvacked
			//so update query will be rollbacked
			
			updateQuery = "UPDATE employee SET salary = salary + ? WHERE id = ?";
			ps = conn.prepareStatement(updateQuery);
			ps.setDouble(1, amountInLPA);
			ps.setInt(2, borrowerEmployeeId);
			ps.executeUpdate();
			
			//sir can you discuss stream api ? if its coming
			//sir I have to ask one thing , can I use try with resources to auto close connection
			
			//you are here means all queries are executed succussfully
			conn.commit();//both update queries will be applied here
		}catch(SQLException ex) {
			//you are here means Something is not okay
			try {
				conn.rollback();
			}catch(SQLException e) {
				throw new SomethingWentWrongException(e.getMessage());
			}
			throw new SomethingWentWrongException(ex.getMessage());
		}finally {
			try {
				DBUtils.closeConnection(conn);				
			}catch(SQLException ex) {
				throw new SomethingWentWrongException(ex.getMessage());
			}
		}
	}

}
