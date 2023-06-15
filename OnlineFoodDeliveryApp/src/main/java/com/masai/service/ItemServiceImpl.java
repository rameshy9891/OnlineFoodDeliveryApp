package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.masai.exception.CategoryException;
import com.masai.exception.ItemException;
import com.masai.model.Category;
import com.masai.model.Item;
import com.masai.model.Restaurant;
import com.masai.repository.ItemRepository;

public class ItemServiceImpl implements ItemService {

	ItemRepository itemRepository;
	
	@Override
	public Item addItem(Item item) {
		if(item == null) throw new ItemException("Category is null") ; 
		
    	Optional<Item> itemOpt = itemRepository.findById(item.getItemId());
    	
    	if(itemOpt.isPresent()) throw new ItemException("Item already present in database") ;
  	
    	
    	return itemRepository.save(itemOpt.get());
	}

	@Override
	public Item updateItem(Item item) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Item viewItem(Item item) {
		Optional<Item> itemOpt = itemRepository.findById(item.getItemId());
		
		if(itemOpt.isEmpty()) throw new ItemException("There is no Item avaliable in the database with this item name"
		  		+ " "+item.getItemName());
		
		Item itemOb = itemOpt.get();
			
		return itemOb;
	}

	@Override
	public Item removeItem(Item item) {
		Optional<Item> itemOpt = itemRepository.findById(item.getItemId());
		
		if(itemOpt.isEmpty()) throw new ItemException("There is no Item avaliable in the database with this item name"
		  		+ " "+item.getItemName());
		
		Item existingItem = itemOpt.get();
			
		itemRepository.delete(existingItem);
		
		return existingItem;
	}

	@Override
	public List<Item> viewAllItems(Item item) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Item> viewAllItems(Restaurant res) {
		return null;
	}

	@Override
	public List<Item> viewAllItemsByName(String name) {
		return null;
	}

}
