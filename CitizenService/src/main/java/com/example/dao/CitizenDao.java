package com.example.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Citizen;

@Repository
public interface CitizenDao extends JpaRepository<Citizen,Integer>{
	public List<Citizen> findByVaccinationCenterId(int id);
}
