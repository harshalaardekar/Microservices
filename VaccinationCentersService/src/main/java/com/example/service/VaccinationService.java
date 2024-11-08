package com.example.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.dao.VaccinationRepo;
import com.example.entity.VaccinationCenter;

@Service
public class VaccinationService {

	@Autowired
	VaccinationRepo dao;
	
	public VaccinationCenter save(VaccinationCenter vc) {
		System.out.println("Inside service");
		return dao.save(vc);
	}
	
	public Optional<VaccinationCenter> getDataByVc(int vcId) {
		System.out.println("insite vc getdata");
		return dao.findById(vcId);
	}
	
}
