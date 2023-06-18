package com.masai.service;

import com.masai.model.FoodCart;
import com.masai.model.Item;


public interface CartService {
	
	public FoodCart addItemToCart(String email, String name, Integer quantity);
	
	public FoodCart increaseQuantity(String email, String name, Integer quantity);
	
	public FoodCart reduceQuantity(String email, String name, Integer quantity);
	
	public FoodCart removeItem(String email, String itemName);
	
	public FoodCart clearCart(String email);
	
}
