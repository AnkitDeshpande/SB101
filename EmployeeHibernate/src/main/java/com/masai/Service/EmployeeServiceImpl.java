package com.masai.Service;

import com.masai.Entity.Employee;
import com.masai.Exception.NoRecordsFoundException;
import com.masai.Exception.SomeThingWentWrongException;
import com.masai.dao.EmployeeDAOImpl;
import com.masai.dao.EmployeeDao;

public class EmployeeServiceImpl implements EmployeeService {

	@Override
	public void save(Employee emp) throws SomeThingWentWrongException {
		EmployeeDao es = new EmployeeDAOImpl();
		es.save(emp);
	}

	@Override
	public String getAddressOfEmployee(int empId) throws SomeThingWentWrongException, NoRecordsFoundException {
		EmployeeDao es = new EmployeeDAOImpl();
		return es.getAddressOfEmployee(empId);
	}

	@Override
	public String giveBonusToEmployee(int empId, int bonus)
			throws SomeThingWentWrongException, NoRecordsFoundException {
		EmployeeDao es = new EmployeeDAOImpl();
		return es.giveBonusToEmployee(empId, bonus);
	}

	@Override
	public boolean deleteEmployee(int empId) throws SomeThingWentWrongException, NoRecordsFoundException {
		EmployeeDao es = new EmployeeDAOImpl();
		return es.deleteEmployee(empId);
	}

}
