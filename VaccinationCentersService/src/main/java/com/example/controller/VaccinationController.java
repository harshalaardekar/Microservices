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
import org.springframework.web.client.RestTemplate;

import com.example.entity.VaccinationCenter;
import com.example.model.Citizen;
import com.example.model.ResponseData;
import com.example.service.VaccinationService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/vaccinationCenter")
public class VaccinationController {
	
	@Autowired
	VaccinationService service;
	
	@Autowired
	RestTemplate restTemplate;
//	RestTemplate restTemplate = new RestTemplate();

	@PostMapping(path ="/add")
	public ResponseEntity<VaccinationCenter> addCitizen(@RequestBody VaccinationCenter vc) {
		
		VaccinationCenter vcAdded = service.save(vc);
		return new ResponseEntity<>(vcAdded, HttpStatus.OK);
	}
	
	@GetMapping(path = "/vcData/{vcID}")
	@HystrixCommand(fallbackMethod = "forCitizenDowntime")
	public ResponseData getDataByVCId(@PathVariable int vcID) {
		System.out.println("get vc data");
		VaccinationCenter vc = service.getDataByVc(vcID).get();
		System.out.println(vc.toString());
		ResponseData rs = new ResponseData();
		rs.setVc(vc);
		
//		String url = "http://localhost:9090/citizen/getData/"+vcID;
		String url = "http://CITIZEN-SERVICE/citizen/getData/"+vcID;
		
		List<Citizen> citizens = restTemplate.getForObject(url, List.class);
		rs.setCitizens(citizens);
		
		return rs;
	}
	
	public ResponseData forCitizenDowntime(@PathVariable int vcId) {
		System.out.println("inside fallback method");
		VaccinationCenter vc = service.getDataByVc(vcId).get();
		System.out.println(vc.toString());
		ResponseData rs = new ResponseData();
		rs.setVc(vc);
		return rs;
	}
}
