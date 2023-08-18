package com.masai.dao;

import com.masai.entity.Employee;
import com.masai.exception.NorecordsFoundException;
import com.masai.exception.SomethingWentWrongException;
import com.masai.utility.EMUtils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public void save(Employee emp) throws SomethingWentWrongException {
		EntityManager em = null;
		EntityTransaction et = null;
		try {
			em = EMUtils.getEM();
			et = em.getTransaction();
			et.begin();
			em.persist(emp);
			et.commit();
			System.out.println("-----------------------------------");
			System.out.println("Employee Added successfully.");
			System.out.println("-----------------------------------");
		} catch (Exception e) {
			if (et != null && et.isActive()) {
				et.rollback();
			}
			e.printStackTrace();
		} finally {
			if (em != null && em.isOpen()) {
				em.close();
			}
		}

	}

	@Override
	public String getAddressOfEmployee(int empId) throws NorecordsFoundException, SomethingWentWrongException {
		EntityManager em = null;
		EntityTransaction et = null;
		try {
			em = EMUtils.getEM();
			et = em.getTransaction();
			et.begin();
			Employee emp = em.find(Employee.class, empId);
			if (emp != null) {
				String add = emp.getAddress();
				et.commit();
				return add;
			} else {
				throw new NorecordsFoundException("Invalid Employee id.");
			}
		} catch (Exception e) {
			et.rollback();
			throw new SomethingWentWrongException("Something went wrong while getting address.");
		} finally {
			em.close();
		}
	}

	@Override
	public String giveBonusToEmployee(int empId, int bonus)
			throws NorecordsFoundException, SomethingWentWrongException {
		EntityManager em = null;
		EntityTransaction et = null;
		Employee emp = null;
		try {
			em = EMUtils.getEM();
			et = em.getTransaction();
			et.begin();
			emp = em.find(Employee.class, empId);
			if (emp != null) {
				emp.setSalary(emp.getSalary() + bonus);
				em.merge(emp);
				et.commit();
				return "Bonus Added Successfully";
			} else {
				throw new NorecordsFoundException("No employee found with given id.");
			}

		} catch (Exception e) {
			et.rollback();
			throw new SomethingWentWrongException("Something went wrong while giving bonus.");
		} finally {
			em.close();
		}
	}

	@Override
	public boolean deleteEmployee(int empId) throws NorecordsFoundException, SomethingWentWrongException {
		EntityManager em = null;
		EntityTransaction et = null;
		try {
			em = EMUtils.getEM();
			et = em.getTransaction();
			et.begin();
			Employee emp = em.find(Employee.class, empId);
			if (emp != null) {
				em.persist(emp);
				et.commit();
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			et.rollback();
			throw new SomethingWentWrongException("Something went wrong while getting address.");
		} finally {
			em.close();
		}
	}

}
