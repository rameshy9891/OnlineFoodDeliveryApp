package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.masai.model.Restaurant;

public interface RestaurantrRepository extends JpaRepository<Restaurant, Integer>,PagingAndSortingRepository<Restaurant, Integer> {
	
	

}
