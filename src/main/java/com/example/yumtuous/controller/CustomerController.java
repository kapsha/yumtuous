package com.example.yumtuous.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.yumtuous.model.Patient;
import com.example.yumtuous.repo.PatientRepository;

@RestController
public class CustomerController {

	@Autowired
	private PatientRepository patientRepository;
	
	@Autowired
	private PatientRepository payerRepository;
	
	@Autowired
	private PatientRepository emergencyContactRepository;	
	
    @GetMapping(value = "/customers")
	public List<Patient> getCustomers() {		
		return (List<Patient>) patientRepository.findAll();
	}

//	@PostMapping("/customers")
//	public @ResponseBody Customer createCustomer(            
//			@RequestParam(value="firstName", required=true) String firstName,
//			@RequestParam(value="lastName", required=true) String lastName,
//			@RequestParam(value="dateOfBirth", required=true)
//			@DateTimeFormat(pattern="yyyy-MM-dd") Date dateOfBirth,
//			@RequestParam(value="email", required=true) String email,
//			@RequestParam(value="mobile", required=true) String mobile) throws Exception {
//		Customer customer = new Customer(firstName+lastName, dateOfBirth);
//		customerRepository.save(customer);
//		return customer;            
//	}
	
	@PostMapping("/customers")
	public @ResponseBody Patient create(@RequestBody Patient customer) {
		UUID uuid = UUID.randomUUID();
		customer.setUuid(uuid.toString());
		customer.setUser_type("patient");
		patientRepository.save(customer);
		return customer;            
	}
	
	@GetMapping("/customers/{customerId}")
	public Patient getCustomer(@PathVariable("customerId") Long customerId) throws Exception {
		/* validate customer Id parameter */
		if (null==customerId) {
			throw new Exception();
		}

		
		Optional<Patient> customer = patientRepository.findById(customerId);
		if(customer.isPresent() == false){
			throw new Exception();
		}

		return customer.get();
	}
}