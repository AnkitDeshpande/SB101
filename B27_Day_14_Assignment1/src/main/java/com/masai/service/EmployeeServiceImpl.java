package com.masai.service;

import com.masai.dao.EmployeeDao;
import com.masai.dao.EmployeeDaoImpl;
import com.masai.entity.Employee;
import com.masai.exception.NorecordsFoundException;
import com.masai.exception.SomethingWentWrongException;

public class EmployeeServiceImpl implements EmployeeService {

	@Override
	public void save(Employee emp) throws SomethingWentWrongException {
		EmployeeDao ed = new EmployeeDaoImpl();
		ed.save(emp);
	}

	@Override
	public String getAddressOfEmployee(int empId) throws NorecordsFoundException, SomethingWentWrongException {
		EmployeeDao ed = new EmployeeDaoImpl();
		return ed.getAddressOfEmployee(empId);
	}

	@Override
	public String giveBonusToEmployee(int empId, int bonus)
			throws NorecordsFoundException, SomethingWentWrongException {
		EmployeeDao ed = new EmployeeDaoImpl();
		return ed.giveBonusToEmployee(empId, bonus);
	}

	@Override
	public boolean deleteEmployee(int empId) throws NorecordsFoundException, SomethingWentWrongException {
		EmployeeDao ed = new EmployeeDaoImpl();
		return ed.deleteEmployee(empId);
	}

}
