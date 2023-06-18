package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.CategoryException;
import com.masai.exception.ItemException;
import com.masai.exception.RestaurantException;
import com.masai.model.Category;
import com.masai.model.Item;
import com.masai.model.Restaurant;
import com.masai.repository.CategoryRepository;
import com.masai.repository.ItemRepository;
import com.masai.repository.RestaurantRepository;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemRepository itemRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private RestaurantRepository restaurantRepository;
	
	@Override
	public Item addItem(Item item, String catName, String restName) {
		if(item == null) throw new ItemException("Item is null") ; 
		
    	Optional<Item> itemOpt = itemRepository.findByItemName(item.getItemName());
    	
    	if(itemOpt.isPresent()) throw new ItemException("Item already present in database") ;
    	
    	Category cate =categoryRepository.findByCategoryName(catName).orElseThrow(()-> new CategoryException("Please provide proper Category"));
    	Restaurant rest =restaurantRepository.findByRestaurantName(restName).orElseThrow(()-> new RestaurantException("There is no Restaurant present with this name:"+restName));
        
    	List<Item> items =cate.getItems();
    	items.add(item);
    	item.setCategory(cate);
    	
    	rest.getItemList().add(item);
        //item.getRestaurants().add(rest);
    
    	return itemRepository.save(item);
	}

	@Override
	public Item updateItem(Item item) {
		if(item == null) throw new ItemException("Item is null") ; 
		
		Optional<Item> itemOpt = itemRepository.findById(item.getItemId());
    	
    	if(itemOpt.isEmpty()) throw new ItemException("Item Not present in database") ;
		
    	Item newItem = itemOpt.get();
    	//newItem.setCategory(item.getCategory());
    	newItem.setCost(item.getCost());
    	newItem.setItemName(item.getItemName());
    	newItem.setQuantity(item.getQuantity());
    	//newItem.setRestaurants(item.getRestaurants());
    	
    	return itemRepository.save(newItem);
	}

	@Override
	public Item viewItem(String name) {
		if(name == null) throw new ItemException("Item is null") ; 
		Optional<Item> itemOpt = itemRepository.findByItemName(name);
		
		if(itemOpt.isEmpty()) throw new ItemException("There is no Item avaliable in the database with name"
		  		+ " "+name);
		
		Item item = itemOpt.get();
			
			return item;
	}

	@Override
	public Item removeItem(String name) {
		  if (name == null) {
		        throw new ItemException("name is null");
		    }

		    Optional<Item> itemOpt = itemRepository.findByItemName(name);

		    if (!itemOpt.isPresent()) {
		        throw new ItemException("There is no Item available in the database with name " + name);
		    }

		    Item existingItem = itemOpt.get();

		    //existingItem.setCategory(null);
		    //existingItem.setRestaurants(null);

		    itemRepository.delete(existingItem);

		    return existingItem;
	
		
	}

	@Override
	public List<Item> viewAllItemsByCategoryName(String categoryName) {
		if(categoryName == null) throw new CategoryException("name is null") ; 
		
		Optional<Category> categoryOpt = categoryRepository.findByCategoryName(categoryName);
		
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
		
		Optional<Restaurant> Opt = restaurantRepository.findByRestaurantName(restaurentName);
		
		if(!Opt.isPresent()) throw new RestaurantException("There is no Restaurant avaliable in the database with Restaurant name"
		  		+ " "+restaurentName);
		
		Restaurant rest =Opt.get();
		 
		
		List<Item> item = rest.getItemList();
		
		if(item.isEmpty()) throw new ItemException("item list is Empty");
		
		return item;
	}



}
