package com.masai.dao;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import com.masai.dto.Medicine;
import com.masai.exceptions.NorecordsFoundException;
import com.masai.exceptions.SomethingWentWrongException;

public interface MedicineDao {
	public void addMed(Medicine med) throws SomethingWentWrongException;

	public void updateMed(String id, String name, String company, BigDecimal price, LocalDate mfgDate,
			LocalDate expDate) throws SomethingWentWrongException, NorecordsFoundException;

	public void deleteMed(String id) throws SomethingWentWrongException, NorecordsFoundException;

	public List<Medicine> viewAllMeds() throws SomethingWentWrongException, NorecordsFoundException;

}
