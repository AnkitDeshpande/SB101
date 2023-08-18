package com.masai.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import com.masai.dao.MedicineDao;
import com.masai.dao.MedicineDaoImpl;
import com.masai.dto.Medicine;
import com.masai.exceptions.NorecordsFoundException;
import com.masai.exceptions.SomethingWentWrongException;

public class MedicineServiceImpl implements MedService {

	@Override
	public void addMed(Medicine med) throws SomethingWentWrongException {
		MedicineDao md = new MedicineDaoImpl();
		md.addMed(med);
	}

	@Override
	public void updateMed(String id, String name, String company, BigDecimal price, LocalDate mfgDate,
			LocalDate expDate) throws SomethingWentWrongException, NorecordsFoundException {
		MedicineDao md = new MedicineDaoImpl();
		md.updateMed(id, name, company, price, mfgDate, expDate);
	}

	@Override
	public void deleteMed(String id) throws SomethingWentWrongException, NorecordsFoundException {
		MedicineDao md = new MedicineDaoImpl();
		md.deleteMed(id);
	}

	@Override
	public List<Medicine> viewAllMeds() throws SomethingWentWrongException, NorecordsFoundException {
		MedicineDao md = new MedicineDaoImpl();
		return md.viewAllMeds();
	}

}
