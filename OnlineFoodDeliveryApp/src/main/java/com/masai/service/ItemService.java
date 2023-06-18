package com.masai.service;

import java.util.List;

import com.masai.model.Item;

public interface ItemService {

	public Item addItem(Item item, String catName, String restName);	
	public Item updateItem(Item item);
	public Item viewItem(String itemName);
	public Item removeItem(String itemName);	
	public List<Item> viewAllItemsByCategoryName(String categoryName);	
	public List<Item> viewAllItemsByRestaurentName(String resName);
	
	
}
