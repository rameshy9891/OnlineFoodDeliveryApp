package com.masai.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Customer;
import com.masai.model.CustomerDTO;
import com.masai.service.CustomerService;

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
	
	@GetMapping("/signIn")
	public ResponseEntity<String> login(Authentication auth){
		
		 Customer customer = customerService.getCustomerDetailsByEmail(auth.getName());
		 
		 return new ResponseEntity<>(customer.getFirstName()+" "+ customer.getLastName()+" Logged In Successfully",HttpStatus.ACCEPTED);
		 
	}
	
	@PutMapping("/customers/{email}")
	public ResponseEntity<Customer> updateCutomerDetails(@RequestBody @Valid CustomerDTO customerDto,@PathVariable("email") String email){
		 
		Customer cust =customerService.updateCustomerDetails(customerDto, email);
	  return new ResponseEntity<>(cust,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/customer/{email}")
	public ResponseEntity<Customer> deleteCutomer(@PathVariable("email") String email){
		 
		Customer cust =customerService.deleteCustomer( email);
	  return new ResponseEntity<>(cust,HttpStatus.OK);
	}
	
	@GetMapping("/customers/{email}")
	public ResponseEntity<Customer> viewCutomer(@PathVariable("email") String email){
		 
		Customer cust =customerService.getCustomerDetailsByEmail(email);
	  return new ResponseEntity<>(cust,HttpStatus.OK);
}
	  
	@GetMapping("/customers")
	   public ResponseEntity<List<Customer>> getAllCustomer() {	    	
	   	List<Customer> customers = customerService.viewAllCustomer();
    	ResponseEntity<List<Customer>> allCustomers = new ResponseEntity<>(customers, HttpStatus.OK);
		return allCustomers;
	    }
}