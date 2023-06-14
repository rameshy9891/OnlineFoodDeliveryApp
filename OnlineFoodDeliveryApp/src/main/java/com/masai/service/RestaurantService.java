package com.masai.service;

import java.util.List;

import com.masai.model.Restaurant;

public interface RestaurantService {
	
	public Restaurant addRestaurant(Restaurant res);
	
	public Restaurant updateRestaurant(Restaurant res);
	
	public Restaurant removeRestaurant(Restaurant res);
	
	public List<Restaurant> viewBearByRestaurant(String location);
	
	public List<Restaurant> viewBearByItemName(String name);
	
	
	

}
