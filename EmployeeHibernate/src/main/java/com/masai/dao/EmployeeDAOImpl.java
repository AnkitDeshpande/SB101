package com.masai.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceException;

import com.masai.Entity.Employee;
import com.masai.Exception.NoRecordsFoundException;
import com.masai.Exception.SomeThingWentWrongException;
import com.masai.Utility.EMUtils;

public class EmployeeDAOImpl implements EmployeeDao {

	@Override
	public void save(Employee emp) throws SomeThingWentWrongException {
		EntityManager em = null;
		EntityTransaction et = null;

		try {
			em = EMUtils.getEntityManager();
			et = em.getTransaction();
			et.begin();
			em.persist(emp);
			et.commit();
		} catch (PersistenceException e) {
			et.rollback();
			throw new SomeThingWentWrongException("Unable to add Employee, Try again later");
		} finally {
			em.close();
		}
	}

	@Override
	public String getAddressOfEmployee(int empId) throws SomeThingWentWrongException, NoRecordsFoundException {
		EntityManager em = null;
		Employee e = null;
		try {
			em = EMUtils.getEntityManager();
			e = em.find(Employee.class, empId);
			if (e == null) {
				throw new NoRecordsFoundException("No Employee Found with the given ID.");
			}
		} catch (IllegalArgumentException ex) {
			throw new SomeThingWentWrongException("Ubale to Fetch Details.");
		}finally {
			em.close();
		}
		
		return e.getAddress();
	}

	@Override
	public String giveBonusToEmployee(int empId, int bonus) throws SomeThingWentWrongException, NoRecordsFoundException {
		EntityManager em = null;
		EntityTransaction et = null;
		Employee e = null;
		try {
			em = EMUtils.getEntityManager();
			et = em.getTransaction();
			e = em.find(Employee.class, empId);
			et.begin();
			em.merge(e);
			e.setSalary(e.getSalary()+bonus);
			et.commit();
			return "Bonus Added Successfully"; 
		} catch (IllegalArgumentException e2) {
			et.rollback();
			throw new SomeThingWentWrongException("Unable to Fetch Details.");
		}finally {
			em.close();
		}
		
	}

	@Override
	public boolean deleteEmployee(int empId) throws SomeThingWentWrongException, NoRecordsFoundException {
		EntityManager em = null;
		EntityTransaction et = null;
		Employee e = null;
		try {
			em = EMUtils.getEntityManager();
			et = em.getTransaction();
			e = em.find(Employee.class, empId);
			et.begin();
			if(e!=null) {
				em.remove(e);
			}else {
				throw new NoRecordsFoundException("No record Available with given ID");
			}
			et.commit();
			return true; 
		} catch (IllegalArgumentException e2) {
			et.rollback();
			throw new SomeThingWentWrongException("Unable to Delete Employee.");
		}finally {
			em.close();
		}
	}

}
