package com.masai.service;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.masai.exception.CustomerException;
import com.masai.model.Customer;
import com.masai.model.CustomerDTO;
import com.masai.model.FoodCart;
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
    	   
    	FoodCart foodCart = new FoodCart();
    	  
    	 foodCart.setCustomer(customer);
    	 customer.setFoodCart(foodCart);
    	  
    		return customerRepository.save(customer) ;
	}

	@Override
	public Customer getCustomerDetailsByEmail(String username) {
		return customerRepository.findByEmail(username).orElseThrow(()-> new CustomerException("There is no User or Admin avaliable in the database with this username"+username));
	}

	@Override
	public Customer updateCustomerDetails(CustomerDTO customerDto, String email){
		   
		Optional<Customer> opt = customerRepository.findByEmail(email);
		
		if(opt.isPresent()) {
			Customer existingCustomer = opt.get();
			
			existingCustomer.setMobileNumber(customerDto.getMobileNumber());
			existingCustomer.setAddress(customerDto.getAddress());
			
			return customerRepository.save(existingCustomer);
			
		}else
		  throw new CustomerException("There is no User or Admin avaliable in the database with this username "+email);
	}

	@Override
	public Customer deleteCustomer(String email) {
		Optional<Customer> opt = customerRepository.findByEmail(email);
		if(opt.isPresent()) {
			Customer existingCustomer = opt.get();
		    
			if(existingCustomer.getRole().equals("ROLE_ADMIN")) {
				throw new CustomerException("One Admin can not remove another Admin");
			}
			
			customerRepository.delete(existingCustomer);
			return existingCustomer;
			
		}else
		  throw new CustomerException("There is no Admin avaliable in the database with this username "+email);
	
		
	}

	@Override
	public List<Customer> viewAllCustomer() {
		
		Pageable pageable = PageRequest.of(0,5, Sort.by("firstName").ascending());
		
		List<Customer> customers = customerRepository.findAll(pageable).getContent();
		if(customers.isEmpty()) throw new CustomerException("Customer list is Empty");
		return customers;
	}

}
