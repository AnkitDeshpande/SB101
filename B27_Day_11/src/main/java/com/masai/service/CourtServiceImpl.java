package com.masai.service;

import java.util.List;

import com.masai.dao.CourtDAO;
import com.masai.dao.CourtDAOImpl;
import com.masai.dto.Lawyer;
import com.masai.exceptions.NorecordsFoundException;
import com.masai.exceptions.SomethingWentWrongException;

public class CourtServiceImpl implements CourtService {

	@Override
	public List<Lawyer> getLawyerList() throws NorecordsFoundException, SomethingWentWrongException {
		CourtDAO cd = new CourtDAOImpl();
		return cd.getLawyerList();
	}

	@Override
	public Lawyer findLawyerById(int id) throws NorecordsFoundException {
		CourtDAO cd = new CourtDAOImpl();
		return cd.findLawyerById(id);
	}

	@Override
	public String saveLawyer(Lawyer lawyer) throws SomethingWentWrongException {
		CourtDAO cd = new CourtDAOImpl();
		return cd.saveLawyer(lawyer);
	}

	@Override
	public String deleteLawyerById(int id) throws NorecordsFoundException {
		CourtDAO cd = new CourtDAOImpl();
		return cd.deleteLawyerById(id);
	}

	@Override
	public String updateLawyerExperience(int id, int experience)
			throws NorecordsFoundException, SomethingWentWrongException {
		CourtDAO cd = new CourtDAOImpl();
		return cd.updateLawyerExperience(id, experience);
	}

}
