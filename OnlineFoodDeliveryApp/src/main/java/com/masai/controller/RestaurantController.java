package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Restaurant;
import com.masai.service.RestaurantServiceImpl;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class RestaurantController {
	
	@Autowired
	RestaurantServiceImpl rservice;
	
	@PostMapping("/addnewrest")
	public String AddRestaurantHandler(@RequestBody Restaurant rest) {
		
		Restaurant finnalyadded=	rservice.addRestaurant(rest);
		
		
		
		
		
		return "added suscefully";
		
	}

}
