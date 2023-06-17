package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.masai.exception.CategoryException;
import com.masai.exception.ItemException;
import com.masai.model.Category;
import com.masai.model.Item;
import com.masai.repository.CategoryRepository;
import com.masai.repository.ItemRepository;

public class ItemServiceImpl implements ItemService {

	@Autowired
	ItemRepository itemRepository;
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@Override
	public Item addItem(Item item, String catName) {
		if(item == null) throw new ItemException("Item is null") ; 
		
    	Optional<Item> itemOpt = itemRepository.findById(item.getItemId());
    	
    	if(itemOpt.isPresent()) throw new ItemException("Item already present in database") ;
    	
    	CategoryService catService = new CategoryServiceImpl(); 
    	
    	Category category = catService.viewCategory(catName);
    	
    	category.getItems().add(item);
    	return itemRepository.save(itemOpt.get());
	}

	@Override
	public Item updateItem(Item item) {
		if(item == null) throw new ItemException("Item is null") ; 
		
		Optional<Item> itemOpt = itemRepository.findById(item.getItemId());
    	
    	if(itemOpt.isEmpty()) throw new ItemException("Item Not present in database") ;
		
    	Item newItem = itemOpt.get();
    	newItem.setCategory(item.getCategory());
    	newItem.setCost(item.getCost());
    	newItem.setItemName(item.getItemName());
    	newItem.setQuantity(item.getQuantity());
    	newItem.setRestaurants(item.getRestaurants());
    	
    	return itemRepository.save(newItem);
	}

	@Override
	public Item viewItem(String name) {
		if(name == null) throw new ItemException("Item is null") ; 
		Optional<Item> itemOpt = itemRepository.findItemByName(name);
		
		if(itemOpt.isEmpty()) throw new ItemException("There is no Item avaliable in the database with name"
		  		+ " "+name);
		
		Item item = itemOpt.get();
			
			return item;
	}

	@Override
	public Item removeItem(String name) {
		if(name == null) throw new ItemException("name is null") ; 
		Optional<Item> itemOpt = itemRepository.findItemByName(name);
		
		if(itemOpt.isEmpty()) throw new ItemException("There is no Item avaliable in the database with name"
		  		+ " "+name);
		
		Item existingItem = itemOpt.get();
			
		itemRepository.delete(existingItem);
		
		return existingItem;
		
	
		
	}

	@Override
	public List<Item> viewAllItemsByCategoryName(String categoryName) {
		if(categoryName == null) throw new CategoryException("name is null") ; 
		
		Optional<Category> categoryOpt = categoryRepository.findCategoryByName(categoryName);
		
		if(categoryOpt.isEmpty()) throw new CategoryException("There is no Category avaliable in the database with category name"
		  		+ " "+categoryName);
		
		Category category = categoryOpt.get();
		
		List<Item> item = category.getItems();
		
		if(item.isEmpty()) throw new ItemException("item list is Empty");
		
		return item;
	}

	@Override
	public List<Item> viewAllItemsByRestaurentName(String restaurentName) {
		if(restaurentName == null) throw new CategoryException("name is null") ; 
		
		Optional<Category> categoryOpt = categoryRepository.findCategoryByName(restaurentName);
		
		if(categoryOpt.isEmpty()) throw new CategoryException("There is no Category avaliable in the database with category name"
		  		+ " "+restaurentName);
		
		Category category = categoryOpt.get();
		
		List<Item> item = category.getItems();
		
		if(item.isEmpty()) throw new ItemException("item list is Empty");
		
		return item;
	}



}
