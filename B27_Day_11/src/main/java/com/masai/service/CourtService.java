package com.masai.service;

import java.util.List;

import com.masai.dto.Lawyer;
import com.masai.exceptions.NorecordsFoundException;
import com.masai.exceptions.SomethingWentWrongException;

public interface CourtService {
	List<Lawyer> getLawyerList() throws NorecordsFoundException, SomethingWentWrongException;

	Lawyer findLawyerById(int id) throws NorecordsFoundException;

	String saveLawyer(Lawyer lawyer) throws SomethingWentWrongException;

	String deleteLawyerById(int id) throws NorecordsFoundException;

	String updateLawyerExperience(int id, int experience) throws NorecordsFoundException, SomethingWentWrongException;
}
