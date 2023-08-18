package com.masaischool.service;

import com.masaischool.dao.EmployeeDAO;
import com.masaischool.dao.EmployeeDAOImpl;
import com.masaischool.dto.Employee;
import com.masaischool.exception.NoEmployeeFoundException;
import com.masaischool.exception.SomethingWentWrongException;

public class EmployeeServiceImpl implements EmployeeService {

	@Override
	public void addEmployee(Employee employee) throws SomethingWentWrongException {
		EmployeeDAO employeeDAO = new EmployeeDAOImpl();
		employeeDAO.addEmployee(employee);
	}
	
	@Override
	public void updateEmployee(Employee employee) throws SomethingWentWrongException, NoEmployeeFoundException{
		EmployeeDAO employeeDAO = new EmployeeDAOImpl();
		employeeDAO.updateEmployee(employee);
	}

}
