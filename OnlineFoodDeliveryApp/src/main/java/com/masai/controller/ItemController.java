package com.masai.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Item;
import com.masai.service.ItemService;

import jakarta.validation.Valid;

@RestController
public class ItemController {
	
	@Autowired
	private ItemService itemService;

//	There's some confusion in this add Method
	@PostMapping("/items/{categoryName}/{restaurantName}")
	public ResponseEntity<Item> addNewCategory(@RequestBody @Valid Item item, @PathVariable("categoryName") String categoryName, @PathVariable("restaurantName") String resName ){

		Item addedItem = itemService.addItem(item, categoryName, resName);
		
		return new ResponseEntity<>(addedItem,HttpStatus.CREATED);
		
	}
	
	
	@PutMapping("/items")
	public ResponseEntity<Item> updateCategory(@RequestBody @Valid Item item){
		
		Item updatedItem = itemService.updateItem(item);
		
		return new ResponseEntity<Item>(updatedItem, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/item/{itemName}")
	public ResponseEntity<Item> viewCategory(@PathVariable("itemName") String catName){
		
		Item item = itemService.viewItem(catName);
		
		return new ResponseEntity<Item>(item, HttpStatus.OK);
		
	}
	
	@DeleteMapping("/items/{itemName}")
	public ResponseEntity<Item> removeItem(@PathVariable("itemName") String itemName){
		
		Item item = itemService.removeItem(itemName);
		
		return new ResponseEntity<>(item,HttpStatus.OK);
	}
	
	@GetMapping("/items/{categoryName}")
	public ResponseEntity<List<Item>> getAllItemBYCategory(@PathVariable("categoryName") String catName){
		
		List<Item> items = itemService.viewAllItemsByCategoryName(catName);
		
		return new ResponseEntity<>(items,HttpStatus.OK);
	}
	
	@GetMapping("/itemslist/{restaurentName}")
	public ResponseEntity<List<Item>> getAllItemyRestaurent(@PathVariable("restaurentName") String resName){
		
		List<Item> items = itemService.viewAllItemsByRestaurentName(resName);
		
		return new ResponseEntity<>(items,HttpStatus.OK);
	}
	
}
