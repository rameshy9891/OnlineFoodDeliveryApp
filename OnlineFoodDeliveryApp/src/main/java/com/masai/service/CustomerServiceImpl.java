package com.masai.service;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.CustomerException;
import com.masai.model.Customer;
import com.masai.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public Customer addCustomer(Customer customer) {
		
		if(customer == null) throw new CustomerException("Customer is null") ; 
    	Optional<Customer> cus = customerRepository.findByEmail(customer.getEmail()) ;
    	if(cus.isPresent()) throw new CustomerException("already present in database") ;
    	
    		return customerRepository.save(customer) ;
	}

	@Override
	public Customer getCustomerDetailsByEmail(String username) {
		return customerRepository.findByEmail(username).orElseThrow(()-> new CustomerException("There is no User or Admin avaliable in the database with this username"+username));
	}

}
