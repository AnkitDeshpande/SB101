package com.masai.service;

import com.masai.entity.Employee;
import com.masai.exception.NorecordsFoundException;
import com.masai.exception.SomethingWentWrongException;

public interface EmployeeService {
	public void save(Employee emp) throws SomethingWentWrongException;

	public String getAddressOfEmployee(int empId) throws NorecordsFoundException, SomethingWentWrongException;

	public String giveBonusToEmployee(int empId, int bonus) throws NorecordsFoundException, SomethingWentWrongException;

	public boolean deleteEmployee(int empId) throws NorecordsFoundException, SomethingWentWrongException;
}
