package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.RestaurantException;
import com.masai.model.Restaurant;
import com.masai.repository.RestaurantRepository;

@Service
public class RestaurantServiceImpl implements RestaurantService {
	
	@Autowired
	RestaurantRepository restaurantRepository;

	@Override
	public Restaurant addRestaurant(Restaurant restaurant) {
		
		if(restaurant==null) {
			throw new RestaurantException(" restaurant is null");
		}
		
		
		
		Optional<Restaurant> rest=  restaurantRepository.findById(restaurant.getRestaurantId());
		
		
		if(rest.isPresent()) {
			throw new RestaurantException("alredy present in the database");
		}
		
//		if(restaurantRepository.existsById(restaurant.getRestaurantId())) {
//			throw new RestaurantException(" Restaurant alredy present in the database");
//		}
	
		
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
			throw new RestaurantException("Restaurant is not present in the database with this id"+restaurant.getRestaurantId());
		}
	
		
		return restaurantRepository.save(restaurant);
		
	
	}

	@Override
	public Restaurant removeRestaurant(Restaurant res) {
		// TODO Auto-generated method stub
		
		if(res==null) {
			throw new RestaurantException(" restaurant is null");
		}
		
	Restaurant fordelete=	restaurantRepository.findById(res.getRestaurantId()).orElseThrow(()-> new RestaurantException("restaurant is not present in database with this id"+res.getRestaurantId()));
		
		restaurantRepository.delete(fordelete);
		
		return fordelete;
	}

	@Override
	public List<Restaurant> viewBearByRestaurant(String location) {
		// TODO Auto-generated method stub
		
		if (location == null || location.isEmpty()) {
			throw new RestaurantException("Location is null or empty");
		}
		
	//Optional<Restaurant>	restorentlocation = restaurantRepository.findByLocation(location);
		
//	if(restorentlocation.isEmpty()) throw new RestaurantException("no restaurant of this location"+" " +location);
//	
//	List<Restaurant> restorentname= (List<Restaurant>) restorentlocation.get();
	
		
		
		//return restorentname;
		return null;
	}

	@Override
	public List<Restaurant> viewBearByItemName(String name) {
		// TODO Auto-generated method stub
		
		if (name == null || name.isEmpty()) {
			throw new RestaurantException("Item name is null or empty");
		}
		
		Optional<Restaurant>	restorentName = restaurantRepository.findByRestaurantName(name);
		
		if(restorentName.isEmpty()) throw new RestaurantException("no restaurant of this name"+" " +name);
		
		List<Restaurant> restorentname= (List<Restaurant>) restorentName.get();
		
			
			
			return restorentname;
	}

}
