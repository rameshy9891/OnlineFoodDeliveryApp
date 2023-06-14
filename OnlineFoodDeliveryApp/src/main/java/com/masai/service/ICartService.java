package com.masai.service;

import com.masai.model.FoodCart;
import com.masai.model.Item;

public interface ICartService {
	
	public FoodCart addItemToCart(FoodCart cart, Item item);
	
	public FoodCart increaseQuantity(FoodCart cart, Item item, int quantity);
	
	public FoodCart reduceQuantity(FoodCart cart, Item item, int quantity);
	
	public FoodCart removeItem(FoodCart cart, Item item);
	
	public FoodCart clearCart(FoodCart cart);
	
	
}
