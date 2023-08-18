package com.masai.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.masai.dao.CourtDAO;
import com.masai.dao.CourtDAOJdbcImpl;
import com.masai.dto.Lawyer;
import com.masai.exception.NoRecordsFoundException;
import com.masai.exception.SomeThingWentWrongException;

public class lawyerServiceImp implements lawyerService{

	@Override
	public List<Lawyer> getLawyerList() throws SomeThingWentWrongException {
		CourtDAO cd = new CourtDAOJdbcImpl(); 
		return cd.getLawyerList();
	}

	@Override
	public Lawyer findLawyerById(int id) throws SomeThingWentWrongException, NoRecordsFoundException {
		CourtDAO cd = new CourtDAOJdbcImpl(); 
		return cd.findLawyerById(id);
	}

	@Override
	public String saveLawyer(Lawyer lawyer) throws SomeThingWentWrongException {
		CourtDAO cd = new CourtDAOJdbcImpl(); 
		return cd.saveLawyer(lawyer);
	}

	@Override
	public String deleteLawyerById(int id) throws SomeThingWentWrongException, NoRecordsFoundException {
		CourtDAO cd = new CourtDAOJdbcImpl(); 
		return cd.deleteLawyerById(id);
	}

	@Override
	public String updateLawyerExperience(int id, int experience)
			throws SomeThingWentWrongException, NoRecordsFoundException {
		CourtDAO cd = new CourtDAOJdbcImpl(); 
		return cd.updateLawyerExperience(id, experience);
	}

	@Override
	public List<Lawyer> getLawyerByExp() throws SomeThingWentWrongException, NoRecordsFoundException {
		CourtDAO cd = new CourtDAOJdbcImpl(); 
		List<Lawyer> ls = cd.getLawyerList();
		
		return ls.stream().filter(lawyer -> lawyer.getExp() > 5 && lawyer.getEmail().contains("j"))
                .sorted(Comparator.comparingInt(Lawyer::getExp).reversed())
                .collect(Collectors.toList());
	}
	
}
