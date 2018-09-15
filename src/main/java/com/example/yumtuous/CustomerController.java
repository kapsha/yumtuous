package com.example.yumtuous;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

	@Autowired
	private CustomerRepository customerRepository;

    @GetMapping(value = "/customers")
	public List<Customer> getCustomers() {		
		return (List<Customer>) customerRepository.findAll();
	}

	@PostMapping("/customers")
	public @ResponseBody Customer createCustomer(            
			@RequestParam(value="firstName", required=true) String firstName,
			@RequestParam(value="lastName", required=true) String lastName,
			@RequestParam(value="dateOfBirth", required=true)
			@DateTimeFormat(pattern="yyyy-MM-dd") Date dateOfBirth,
			@RequestParam(value="email", required=true) String email,
			@RequestParam(value="mobile", required=true) String mobile) throws Exception {
		Customer customer = new Customer(firstName, lastName, dateOfBirth);
		customerRepository.save(customer);
		return customer;            
	}

	@GetMapping("/customers/{customerId}")
	public Customer getCustomer(@PathVariable("customerId") Long customerId) throws Exception {
		/* validate customer Id parameter */
		if (null==customerId) {
			throw new Exception();
		}

		Optional<Customer> customer = customerRepository.findById(customerId);
		if(customer.isPresent() == false){
			throw new Exception();
		}

		return customer.get();
	}
}