package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Citizen;
import com.example.service.CitizenService;

@RestController
@RequestMapping("/citizen")
public class CitizenController {
	@Autowired
	CitizenService service;
	
	@PostMapping("/addCitizen")
	public ResponseEntity<Citizen> addCitizen(@RequestBody Citizen citizen){
		System.out.println("Inside controller");
		return new ResponseEntity<Citizen>(service.addCitizen(citizen),HttpStatus.OK);
	}
	
	@GetMapping(path="/getData/{id}")
	public ResponseEntity<List<Citizen>> getByCenterId(@PathVariable int id){
		System.out.println("port used for citizen service: "+System.getenv("server.port"));
		return new ResponseEntity<List<Citizen>>(service.getByVaccinationCenterId(id),HttpStatus.OK);
				
	}
}
