package com.masai.service;

import com.masai.model.Customer;

public interface CustomerService {
	
	public Customer addCustomer(Customer customer);

	public Customer getCustomerDetailsByEmail(String name);

}
