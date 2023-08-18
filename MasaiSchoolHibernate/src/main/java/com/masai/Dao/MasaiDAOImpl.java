package com.masai.Dao;

import com.masai.Entity.Student;
import com.masai.Exception.NoRecordFoundException;
import com.masai.Exception.SomethingWentWrongException;
import com.masai.Service.MasaiService;
import com.masai.Service.MasaiServiceImpl;
import com.masai.Utility.EMUtils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceException;

public class MasaiDAOImpl implements MasaiDAO {

	@Override
	public Student findStudentById(int id) throws NoRecordFoundException, SomethingWentWrongException {
		EntityManager em = null;
		Student s = null;
		try {
			em = EMUtils.getEntityManager();
			s = em.find(Student.class, id);
			if (s == null) {
				throw new NoRecordFoundException("No record Available.");
			} else {
				return s;
			}
		} catch (IllegalArgumentException e) {
			throw new SomethingWentWrongException("Unable to find Student with given ID.");
		} finally {
			em.close();
		}
	}

	@Override
	public String saveStudent(Student student) throws SomethingWentWrongException {
		EntityManager em = null;
		EntityTransaction et = null; 
		try {
			em = EMUtils.getEntityManager();
			et = em.getTransaction();
			et.begin();
			em.persist(student);
			et.commit();
			return "Student Added Successfully";
		} catch (PersistenceException e) {
			et.rollback();
			throw new SomethingWentWrongException("Unable to add Student, Try again later");
		} finally {
			em.close();
		}
		
	}

	@Override
	public String deleteStudentById(int id) throws NoRecordFoundException, SomethingWentWrongException {

		EntityManager em = null;
		EntityTransaction et = null;
		Student s = null;
		MasaiService ms = new MasaiServiceImpl();
		try {
			em = EMUtils.getEntityManager();
			et = em.getTransaction();
			et.begin();
			s = em.find(Student.class, id);
			if(s==null) {
				throw new NoRecordFoundException("No record Available");
			}else {
				em.remove(s);
			}
			et.commit();
			return "Student deleted successfully";
		} catch (IllegalArgumentException e) {
			et.rollback();
			throw new NoRecordFoundException("Unable to delete Student.");
		}finally {
			em.close();
		}
	}

	@Override
	public String updateStudentLevel(int id, int level) throws NoRecordFoundException, SomethingWentWrongException {
		EntityManager em = null;
		EntityTransaction et = null;
		Student s = null;
		try {
			em = EMUtils.getEntityManager();
			et = em.getTransaction();
			et.begin();
			s = em.find(Student.class, id);
			if(s == null) {
				throw new NoRecordFoundException("No record Available");
			}else {
				s.setLevel(level);
			}
			et.commit();
			return "Student Updated Successfully";
		} catch (IllegalArgumentException e) {
			et.rollback();
			throw new NoRecordFoundException("Unable to update Student.");
		}finally {
			em.close();
		}
	}

}
