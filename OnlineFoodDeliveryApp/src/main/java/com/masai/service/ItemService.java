package com.masai.service;

import java.util.List;

import com.masai.model.Item;
import com.masai.model.Restaurant;

public interface ItemService {

	public Item addItem(Item item);	
	public Item updateItem(Item item);
	public Item viewItem(Item item);
	public Item removeItem(Item item);	
	public List<Item> viewAllItems(Item item);	
	public List<Item> viewAllItems(Restaurant res);	
	public List<Item> viewAllItemsByName(String name);	
	
	
}
