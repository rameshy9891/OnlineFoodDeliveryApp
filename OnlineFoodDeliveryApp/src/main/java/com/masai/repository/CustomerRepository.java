package com.masai.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.masai.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer>, PagingAndSortingRepository<Customer,Integer>{

	public Optional<Customer> findByEmail(String username);

}
