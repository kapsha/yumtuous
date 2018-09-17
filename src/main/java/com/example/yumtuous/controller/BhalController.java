package com.example.yumtuous.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.yumtuous.model.BhalSubscription;
import com.example.yumtuous.model.EmergencyContact;
import com.example.yumtuous.model.Patient;
import com.example.yumtuous.model.Payer;
import com.example.yumtuous.repo.EmergencyContactRepository;
import com.example.yumtuous.repo.PatientRepository;
import com.example.yumtuous.repo.PayerRepository;

@RestController
public class BhalController {
	@Autowired
	private PatientRepository patientRepository;
	
	@Autowired
	private EmergencyContactRepository sosContactRepository;	
	
	@Autowired
	private PayerRepository payerRepository;
	
	@PostMapping("/subs/new")
	public @ResponseBody BhalSubscription create(@RequestBody BhalSubscription subs) {
		
		Patient patient = subs.getPatient();
//		if (patient == null) return 400;
		EmergencyContact sosContact = subs.getSosContact();
//		if (patient == null) return 400;		
		Payer payer = subs.getPayer();
//		if (patient == null) return 400;
		
		patient.setUuid(UUID.randomUUID().toString());
		patient.setUser_type("patient");
		patientRepository.save(patient);
		
		sosContact.setUuid(UUID.randomUUID().toString());
		sosContact.setUser_type("emergency");
		sosContactRepository.save(sosContact);
		
		payer.setUuid(UUID.randomUUID().toString());
		payer.setUser_type("payer");
		payerRepository.save(payer);

		return subs;            
	}
}