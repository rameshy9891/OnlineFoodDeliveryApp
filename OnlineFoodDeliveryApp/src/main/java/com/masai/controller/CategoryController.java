package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Category;
import com.masai.model.Customer;
import com.masai.service.CategoryService;

import jakarta.validation.Valid;

@RestController
public class CategoryController {

	@Autowired
	CategoryService categoryService ;
	
	
	@PostMapping("/categories")
	public ResponseEntity<Category> addNewCategory(@RequestBody @Valid Category category) {

		Category cat= categoryService.addCategory(category);
		
		return new ResponseEntity<>(cat,HttpStatus.CREATED);
		
	}
	
	
	
	@PutMapping("/categories")
	public ResponseEntity<Category> updateCategory(@RequestBody @Valid Category category){
		
		Category cat = categoryService.updateCategory(category);
		
		return new ResponseEntity<Category>(cat, HttpStatus.ACCEPTED);
	}
	
	
	
	@DeleteMapping("/categories/{catId}")
	public ResponseEntity<Category> removeCategory(@PathVariable("catId") String catId){
		 
	Category cat = categoryService.removeCategory(catId);
	
	  return new ResponseEntity<Category>(cat, HttpStatus.OK);
	}
	
	
	
	@GetMapping("/categories/{catName}")
	public ResponseEntity<Category> viewCategory(@PathVariable("catName") String catName){
		
		Category cat = categoryService.viewCategory(catName);
		
		return new ResponseEntity<Category>(cat, HttpStatus.OK);
		
	}
	
	@GetMapping("/categories")
	   public ResponseEntity<List<Category>> viewAllCategory() {	    	
	   	List<Category> categories = categoryService.viewAllCategory();
	   	
	   	ResponseEntity<List<Category>> allCategory = new ResponseEntity<>(categories, HttpStatus.OK);
	   	
		return allCategory;
	}
}