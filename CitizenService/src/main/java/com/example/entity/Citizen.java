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
public class Citizen {
	@Id
	@SequenceGenerator(name = "citizen_seq",allocationSize = 1,initialValue = 100)
	@GeneratedValue(generator = "citizen_seq",strategy = GenerationType.AUTO)
	private int cid;
	
	@Column
	private String name;
	
	@Column
	private int vaccinationCenterId;

	
}
