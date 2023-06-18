package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.FoodCart;
import com.masai.service.CartService;

@RestController
public class FoodCartController {

	@Autowired
	private CartService iCartService;
	
	@PatchMapping("/addItem/{email}/{itemName}")
	public ResponseEntity<FoodCart> addItemToCartHandler(@PathVariable("email") String email,
														@PathVariable("itemName") String name,
														@RequestParam("quantity") Integer quantity){
		
		FoodCart cart = iCartService.addItemToCart(email, name, quantity);
		
		return new ResponseEntity<FoodCart>(cart,HttpStatus.OK);
		
	}
	
	@PatchMapping("/increaseQty/{email}/{itemName}")
	public ResponseEntity<FoodCart> increaseItemQuantityHandler(@PathVariable("email") String email,
			@PathVariable("itemName") String itemName, @RequestParam("quantity") Integer quantity){
		
		FoodCart cart = iCartService.increaseQuantity(email, itemName, quantity);
		
		return new ResponseEntity<FoodCart>(cart,HttpStatus.OK);
		
	}
	
	@PatchMapping("/reduceQty/{email}/{itemName}")
	public ResponseEntity<FoodCart> reduceItemQuantityHandler(@PathVariable("email") String email,
			@PathVariable("itemName") String itemName, @RequestParam("quantity") Integer quantity){
		
		FoodCart cart = iCartService.reduceQuantity(email, itemName, quantity);
		
		return new ResponseEntity<FoodCart>(cart,HttpStatus.OK);
		
	}
	
	@PatchMapping("/removeItem/{email}/{itemName}")
	public ResponseEntity<FoodCart> removeItemHandler(@PathVariable("email") String email,
			@PathVariable("itemName") String name){
		
		FoodCart cart = iCartService.removeItem(email,name);
		
		return new ResponseEntity<FoodCart>(cart,HttpStatus.OK);
		
	}
	
	@PatchMapping("/clearCart/{email}")
	public ResponseEntity<FoodCart> clearCartHandler(@PathVariable("email") String email){
		
		FoodCart cart = iCartService.clearCart(email);
		
		return new ResponseEntity<FoodCart>(cart,HttpStatus.OK);
		
	}
	
	
}
