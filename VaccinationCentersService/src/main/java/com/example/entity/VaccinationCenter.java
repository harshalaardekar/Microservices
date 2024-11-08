package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VaccinationCenter {

	@Id
	@SequenceGenerator(name = "vcseq",allocationSize = 1,initialValue = 101)
	@GeneratedValue(generator = "vcseq",strategy = GenerationType.AUTO)
	private int vaccinationCenterId;
	
	@Column
	private String centerName;
	
	@Column
	private String city;
}
