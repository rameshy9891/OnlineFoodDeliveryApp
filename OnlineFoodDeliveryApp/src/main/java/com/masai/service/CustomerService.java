package com.masai.service;

import java.util.List;

import com.masai.model.Customer;
import com.masai.model.CustomerDTO;

public interface CustomerService {
	
	public Customer addCustomer(Customer customer);

	public Customer getCustomerDetailsByEmail(String name);
	
	public Customer updateCustomerDetails(CustomerDTO customerDto,String email);
	
	public Customer deleteCustomer(String email);
	
	public List<Customer> viewAllCustomer();

}
