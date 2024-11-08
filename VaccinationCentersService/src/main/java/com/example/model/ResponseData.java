package com.example.model;

import java.util.List;

import com.example.entity.VaccinationCenter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseData {
	private List<Citizen> citizens;
	private VaccinationCenter vc;
}
