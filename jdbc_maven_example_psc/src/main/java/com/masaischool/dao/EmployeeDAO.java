package com.masaischool.dao;

import com.masaischool.dto.Employee;
import com.masaischool.exception.NoEmployeeFoundException;
import com.masaischool.exception.SomethingWentWrongException;

public interface EmployeeDAO {
	public void addEmployee(Employee employee) throws SomethingWentWrongException;
	public void updateEmployee(Employee employee) throws SomethingWentWrongException, NoEmployeeFoundException;
	public void borrowAmount(Integer lenderEmployeeId, Integer borrowerEmployeeId, double amountInLPA) throws SomethingWentWrongException, NoEmployeeFoundException;
}
