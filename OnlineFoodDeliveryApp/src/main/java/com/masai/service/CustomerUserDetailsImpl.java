package com.masai.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.masai.model.Customer;
import com.masai.repository.CustomerRepository;

@Service
public class CustomerUserDetailsImpl implements UserDetailsService{

	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		  Optional<Customer> opt = customerRepository.findByEmail(username);
		   
		  if(opt.isPresent()) {
			  Customer cust= opt.get();
			    String user = cust.getEmail();
			    String password = cust.getPassword();
			    
			    List<GrantedAuthority> authorities = new ArrayList<>();
			    
			    SimpleGrantedAuthority sga = new SimpleGrantedAuthority(cust.getRole());
			    
			    authorities.add(sga);
			    
			    return new User(user, password, authorities);
		  }
		  
		  else {
			  throw new BadCredentialsException("User details not found with this username : "+ username);
		  }
		    
		    
		    
		    
		
	}

	
}
