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
		EntityTransaction et = null;
		Student st = null;
		try {
			em = EMUtils.getEntityManager();
			et = em.getTransaction();
			et.begin();
			st = em.find(Student.class, id);
			if (st != null) {
				et.commit();
				return st;
			} else {
				et.rollback();
				throw new NoRecordFoundException("No record with the given id.");
			}
		} catch (Exception e) {
			et.rollback();
			throw new NoRecordFoundException("No record with the given id.");
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
			System.out.println(em);
			et = em.getTransaction();
			et.begin();
			em.persist(student);
			et.commit();
			return "Student added successfully.";
		} catch (Exception e) {
			et.rollback();
			e.printStackTrace();
			/* throw new SomethingWentWrongException("No record with the given id."); */
		} finally {
			if (em != null) {
				em.close();
			}
		}
		return null;
	}

	@Override
	public String deleteStudentById(int id) throws NoRecordFoundException, SomethingWentWrongException {

		EntityManager em = null;
		EntityTransaction et = null;
		Student st = null;
		try {
			em = EMUtils.getEntityManager();
			et = em.getTransaction();
			et.begin();
			st = em.find(Student.class, id);
			if (st != null) {
				em.remove(st);
				et.commit();
				return "Student removed Successfully.";
			} else {
				et.rollback();
				throw new NoRecordFoundException("No record with the given id.");
			}
		} catch (Exception e) {
			et.rollback();
			throw new NoRecordFoundException("No record with the given id.");
		} finally {
			em.close();
		}
	}

	@Override
	public String updateStudentLevel(int id, int level) throws NoRecordFoundException, SomethingWentWrongException {

		EntityManager em = null;
		EntityTransaction et = null;
		Student st = null;
		try {
			em = EMUtils.getEntityManager();
			 et = em.getTransaction();
			 et.begin();
			st = em.find(Student.class, id);
			if (st != null) {
				st.setLevel(level);
				em.merge(st);
				et.commit();
				return "Student updated successfully Successfully.";
			} else {
				 et.rollback();
				throw new NoRecordFoundException("No record with the given id.");
			}
		} catch (Exception e) {
			 et.rollback();
			throw new NoRecordFoundException("No record with the given id.");
		} finally {
			em.close();
		}
	}

}
