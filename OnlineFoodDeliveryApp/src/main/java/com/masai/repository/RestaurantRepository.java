package com.masai.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.masai.model.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Integer>,PagingAndSortingRepository<Restaurant, Integer> {
	
//	@Query("SELECT r FROM Restaurant r WHERE r.Address.pincode =?1")
//	public Optional<Restaurant> findByLocation(String location);
	
	public Optional<Restaurant> findByRestaurantName(String name);

}
