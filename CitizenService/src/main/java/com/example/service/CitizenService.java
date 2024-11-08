package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.CitizenDao;
//import com.example.dao.CitizenDao;
import com.example.entity.Citizen;

@Service
public class CitizenService {
	@Autowired
	CitizenDao dao;
	
	public Citizen addCitizen(Citizen citizen) {
		System.out.println("Inside Service Class " + citizen);
		return dao.save(citizen);
	}
	
	public List<Citizen> getByVaccinationCenterId(int id){
		return dao.findByVaccinationCenterId(id);
	}
}
