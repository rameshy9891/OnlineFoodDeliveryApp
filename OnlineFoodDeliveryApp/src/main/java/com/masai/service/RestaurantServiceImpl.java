package com.masai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.masai.exception.RestaurantException;
import com.masai.model.Restaurant;
import com.masai.repository.RestaurantrRepository;

public class RestaurantServiceImpl implements RestaurantService {
	
	@Autowired
	RestaurantrRepository restaurantRepository;

	@Override
	public Restaurant addRestaurant(Restaurant restaurant) {
		
		if(restaurant==null) {
			throw new RestaurantException(" restaurant is null");
		}
		
		
		if(restaurantRepository.existsById(restaurant.getRestaurantId())) {
			throw new RestaurantException(" Restaurant alredy present in the database");
		}
	
		
		Restaurant restorentadd= restaurantRepository.save(restaurant);
		
		return restorentadd;
	}

	@Override
	public Restaurant updateRestaurant(Restaurant restaurant) {
		// TODO Auto-generated method stub
		if(restaurant==null) {
			throw new RestaurantException(" restaurant is null");
		}
		
		
		if(!restaurantRepository.existsById(restaurant.getRestaurantId())) {
			throw new RestaurantException("Restaurant is not present in the database");
		}
	
		
		Restaurant updatedrestaurant= restaurantRepository.save(restaurant);
		
		return updatedrestaurant;
	}

	@Override
	public Restaurant removeRestaurant(Restaurant res) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Restaurant> viewBearByRestaurant(String location) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Restaurant> viewBearByItemName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
