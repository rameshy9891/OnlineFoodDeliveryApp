package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.masai.exception.CategoryException;
import com.masai.model.Category;
import com.masai.model.Item;
import com.masai.repository.CategoryRepository;

public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryRepository categoryRepository;
	
	@Override
	public Category addCategory(Category cat) {
		if(cat == null) throw new CategoryException("Category is null") ; 
		
    	Optional<Category> category = categoryRepository.findById(cat.getCatId());
    	
    	if(category.isPresent()) throw new CategoryException("Category already present in database") ;
    	
    	List<Item> catItems = category.get().getItems();
    	
    	return categoryRepository.save(category.get());
	}

	@Override
	public Category updateCategory(Category cat) {
		Optional<Category> categoryOpt = categoryRepository.findById(cat.getCatId());
		
		if(categoryOpt.isEmpty()) throw new CategoryException("There is no Category avaliable in the database with category name"
		  		+ " "+cat.getCategoryName());
		
		Category category = categoryOpt.get();
		
		category.setCategoryName(cat.getCategoryName());
		category.getItems().addAll(cat.getItems());
		
		return category;
		
	}

	@Override
	public Category removeCategory(String catId) {
		Optional<Category> categoryOpt = categoryRepository.findById(Integer.parseInt(catId));
		
		if(categoryOpt.isEmpty()) throw new CategoryException("There is no Category avaliable in the database with category name"
		  		+ " "+categoryOpt.get().getCategoryName());
		
		
		Category existingCategory = categoryOpt.get();
			
		categoryRepository.delete(existingCategory);
		
		return existingCategory;

		  
	}

	@Override
	public Category viewCategory(String name) {
		Optional<Category> categoryOpt = categoryRepository.findCategoryByName(name);
		
		if(categoryOpt.isEmpty()) throw new CategoryException("There is no Category avaliable in the database with category name"
		  		+ " "+name);
		
		Category category = categoryOpt.get();
			
			return category;
		  
	}

	@Override
	public List<Category> viewAllCategory( ) {
		Pageable pageable = PageRequest.of(0,5, Sort.by("categoryName").ascending());
		
		List<Category> categories = categoryRepository.findAll(pageable).getContent();
		if(categories.isEmpty()) throw new CategoryException("category list is Empty");
		return categories;
	}

}
