package com.masai.service;

import java.util.List;

import com.masai.dto.Lawyer;
import com.masai.exception.NoRecordsFoundException;
import com.masai.exception.SomeThingWentWrongException;

public interface lawyerService {
	List<Lawyer> getLawyerList() throws SomeThingWentWrongException;
	Lawyer findLawyerById(int id) throws SomeThingWentWrongException, NoRecordsFoundException;
	String saveLawyer(Lawyer lawyer) throws SomeThingWentWrongException;
	String deleteLawyerById(int id) throws SomeThingWentWrongException, NoRecordsFoundException;
	String updateLawyerExperience(int id, int experience) throws SomeThingWentWrongException, NoRecordsFoundException;
	List<Lawyer> getLawyerByExp() throws SomeThingWentWrongException, NoRecordsFoundException;
}
