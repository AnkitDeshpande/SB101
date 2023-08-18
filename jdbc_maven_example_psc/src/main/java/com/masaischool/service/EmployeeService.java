package com.masaischool.service;

import com.masaischool.dto.Employee;
import com.masaischool.exception.NoEmployeeFoundException;
import com.masaischool.exception.SomethingWentWrongException;

public interface EmployeeService {
	public void addEmployee(Employee employee) throws SomethingWentWrongException;
	public void updateEmployee(Employee employee) throws SomethingWentWrongException, NoEmployeeFoundException;
}
