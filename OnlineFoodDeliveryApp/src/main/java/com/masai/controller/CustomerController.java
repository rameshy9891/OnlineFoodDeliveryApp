package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Customer;
import com.masai.service.CustomerService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

@RestController
public class CustomerController {
   
	@Autowired
	private CustomerService customerService; 
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@PostMapping("/customers")
	public ResponseEntity<Customer> addNewCustomer(@RequestBody @Valid Customer customer) {
		
		 customer.setPassword(passwordEncoder.encode(customer.getPassword()));
		 customer.setRole("ROLE_"+customer.getRole().toUpperCase());
		
		Customer cust= customerService.addCustomer(customer);
		
		return new ResponseEntity<>(cust,HttpStatus.CREATED);
		
	}
	
	@PostMapping("/signIn")
	public ResponseEntity<String> login(Authentication auth){
		
		 Customer customer = customerService.getCustomerDetailsByEmail(auth.getName());
		 
		 return new ResponseEntity<>(customer.getFirstName()+" "+ customer.getLastName()+" Logged In Successfully",HttpStatus.ACCEPTED);
		 
	}
}
