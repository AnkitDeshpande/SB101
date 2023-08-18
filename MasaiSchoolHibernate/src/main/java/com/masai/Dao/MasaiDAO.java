package com.masai.Dao;

import com.masai.Entity.Student;
import com.masai.Exception.NoRecordFoundException;
import com.masai.Exception.SomethingWentWrongException;

public interface MasaiDAO {
	Student findStudentById(int id) throws NoRecordFoundException, SomethingWentWrongException;

	String saveStudent(Student student) throws SomethingWentWrongException;

	String deleteStudentById(int id) throws NoRecordFoundException, SomethingWentWrongException;

	String updateStudentLevel(int id, int level) throws NoRecordFoundException, SomethingWentWrongException;
}
