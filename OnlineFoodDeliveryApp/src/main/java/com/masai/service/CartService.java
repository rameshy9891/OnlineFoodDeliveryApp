package com.masai.service;

import com.masai.model.FoodCart;
import com.masai.model.Item;


public interface CartService {
	
	public FoodCart addItemToCart(Integer cartId, Item item);
	
	public FoodCart increaseQuantity(Integer cartId, Integer itemId, Integer quantity);
	
	public FoodCart reduceQuantity(Integer cartId, Integer itemId, Integer quantity);
	
	public FoodCart removeItem(Integer cartId, Integer itemId);
	
	public FoodCart clearCart(Integer cartId);
	
}
