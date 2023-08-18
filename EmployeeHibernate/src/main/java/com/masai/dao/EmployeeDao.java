package com.masai.dao;

import com.masai.Entity.Employee;
import com.masai.Exception.NoRecordsFoundException;
import com.masai.Exception.SomeThingWentWrongException;

public interface EmployeeDao {
	public void save(Employee emp) throws SomeThingWentWrongException;

	public String getAddressOfEmployee(int empId) throws SomeThingWentWrongException, NoRecordsFoundException;

	public String giveBonusToEmployee(int empId, int bonus) throws SomeThingWentWrongException, NoRecordsFoundException;

	public boolean deleteEmployee(int empId) throws SomeThingWentWrongException, NoRecordsFoundException;
}
