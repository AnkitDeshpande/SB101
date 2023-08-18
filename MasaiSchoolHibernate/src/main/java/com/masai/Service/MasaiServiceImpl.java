package com.masai.Service;

import com.masai.Dao.MasaiDAO;
import com.masai.Dao.MasaiDAOImpl;
import com.masai.Entity.Student;
import com.masai.Exception.NoRecordFoundException;
import com.masai.Exception.SomethingWentWrongException;

public class MasaiServiceImpl implements MasaiService {

	@Override
	public Student findStudentById(int id) throws NoRecordFoundException, SomethingWentWrongException {
		MasaiDAO ms = new MasaiDAOImpl();
		return ms.findStudentById(id);
	}

	@Override
	public String saveStudent(Student student) throws SomethingWentWrongException {
		MasaiDAO ms = new MasaiDAOImpl();
		return ms.saveStudent(student);
	}

	@Override
	public String deleteStudentById(int id) throws NoRecordFoundException, SomethingWentWrongException {
		MasaiDAO ms = new MasaiDAOImpl();
		return ms.deleteStudentById(id);
	}

	@Override
	public String updateStudentLevel(int id, int level) throws NoRecordFoundException, SomethingWentWrongException {
		MasaiDAO ms = new MasaiDAOImpl();
		return ms.updateStudentLevel(id, level);
	}

}
