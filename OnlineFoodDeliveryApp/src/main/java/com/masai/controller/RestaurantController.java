package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Restaurant;
import com.masai.service.RestaurantService;

import jakarta.validation.Valid;

@RestController
public class RestaurantController {
	
	@Autowired
	private RestaurantService restaurantService;
	
	@PostMapping("/Restaurant")
	public ResponseEntity<Restaurant> AddRestaurantHandler(@RequestBody @Valid Restaurant rest) {
		
		Restaurant restorent=	restaurantService.addRestaurant(rest);
		
		
		return new ResponseEntity<Restaurant>(restorent,HttpStatus.CREATED);
		
	}
	
	@PutMapping("/Restaurant/{restaurantId}")
	public ResponseEntity<Restaurant> updateRestaurantHandler(@RequestBody @Valid Restaurant rest){
		
Restaurant restorent=	restaurantService.updateRestaurant(rest);
		
		
		return new ResponseEntity<Restaurant>(restorent,HttpStatus.OK);
		
	}
	
	
	@DeleteMapping("/Restaurant/{restaurantId}")
	public ResponseEntity<Restaurant> deleteRestaurantHandler(@RequestBody @Valid Restaurant rest){
		
Restaurant restorent=	restaurantService.removeRestaurant(rest);
		
		
		return new ResponseEntity<Restaurant>(restorent,HttpStatus.OK);
		
	}
	
	@GetMapping("/Restaurant/{name}")
	public ResponseEntity<List<Restaurant>> getRestaurentByName(@RequestBody @Valid Restaurant rest){
		
List<Restaurant> restorent=	restaurantService.viewBearByItemName(rest.getRestaurantName());
		
		
		return new ResponseEntity<List<Restaurant>>(restorent,HttpStatus.OK);
		
	}
	
	
	@GetMapping("/Restaurant/{location}")
	public ResponseEntity<List<Restaurant>> getRestaurentByLocation(@RequestBody @Valid Restaurant rest){
		
List<Restaurant> restorent=	restaurantService.viewBearByItemName(rest.getAddress().getCity());
		
		
		return new ResponseEntity<List<Restaurant>>(restorent,HttpStatus.OK);
		
	}
	
	

}
