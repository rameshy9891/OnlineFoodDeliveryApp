package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import com.masai.model.FoodCart;
import com.masai.model.Item;
import com.masai.service.CartService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@Repository
public class FoodCartController {

	@Autowired
	private CartService iCartService;
	
	@PutMapping("/addItem/{cartId}")
	public ResponseEntity<FoodCart> addItemToCartHandler(@PathVariable("cartId") Integer cartId,
														@RequestBody Item item){
		
		FoodCart cart = iCartService.addItemToCart(cartId, item);
		
		return new ResponseEntity<FoodCart>(cart,HttpStatus.OK);
		
	}
	
	@PutMapping("/increaseQty/{cartId}/{itemId}/{quantity}")
	public ResponseEntity<FoodCart> increaseItemQuantityHandler(@PathVariable("cartId") Integer cartId,
			@PathVariable("itemId") Integer itemId, @PathVariable("quantity") Integer qty){
		
		FoodCart cart = iCartService.increaseQuantity(cartId, itemId, qty);
		
		return new ResponseEntity<FoodCart>(cart,HttpStatus.OK);
		
	}
	
	@PutMapping("/reduceQty/{cartId}/{itemId}/{quantity}")
	public ResponseEntity<FoodCart> reduceItemQuantityHandler(@PathVariable("cartId") Integer cartId,
			@PathVariable("itemId") Integer itemId, @PathVariable("quantity") Integer qty){
		
		FoodCart cart = iCartService.reduceQuantity(cartId, itemId, qty);
		
		return new ResponseEntity<FoodCart>(cart,HttpStatus.OK);
		
	}
	
	@PutMapping("/removeItem/{cartId}/{itemId}")
	public ResponseEntity<FoodCart> reduceItemQuantityHandler(@PathVariable("cartId") Integer cartId,
			@PathVariable("itemId") Integer itemId){
		
		FoodCart cart = iCartService.removeItem(cartId, itemId);
		
		return new ResponseEntity<FoodCart>(cart,HttpStatus.OK);
		
	}
	
	@PutMapping("/clearCart/{cartId}")
	public ResponseEntity<FoodCart> clearCartHandler(@PathVariable("cartId") Integer cartId){
		
		FoodCart cart = iCartService.clearCart(cartId);
		
		return new ResponseEntity<FoodCart>(cart,HttpStatus.OK);
		
	}
	
	
}
