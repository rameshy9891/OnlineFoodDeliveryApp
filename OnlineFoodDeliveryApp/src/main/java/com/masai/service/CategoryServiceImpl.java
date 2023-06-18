package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.masai.exception.CategoryException;
import com.masai.model.Category;
import com.masai.model.Item;
import com.masai.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryRepository categoryRepository;
	
	@Override
	public Category addCategory(Category cat) {
		if(cat == null) throw new CategoryException("Category is null") ; 
		
    	Optional<Category> category = categoryRepository.findByCategoryName(cat.getCategoryName());
    	
    	if(category.isPresent()) throw new CategoryException("Category already present in database") ;
//    	
//    	Category cate = category.get();
//    	List<Item> itemList = cate.getItems();
    	
//    	for(Item k : itemList ) {
//    		k.setCategory(cat);
//    	}
//    	
//    	cat.setItems(itemList);
    	
    	return categoryRepository.save(cat);
	}

	@Override
	public Category updateCategory(String oldName, String newName) {
		Optional<Category> categoryOpt = categoryRepository.findByCategoryName(oldName);
		
		if(!categoryOpt.isPresent()) throw new CategoryException("There is no Category avaliable in the database with category name"
		  		+ " "+oldName);
		
		Category category = categoryOpt.get();
		
		category.setCategoryName(newName);
		//category.getItems().addAll(cat.getItems());
		return categoryRepository.save(category);
		
	}

	@Override
	public Category removeCategory(Integer catId) {
		Optional<Category> categoryOpt = categoryRepository.findById(catId);
		
		if(!categoryOpt.isPresent()) throw new CategoryException("There is no Category avaliable in the database with category name"
		  		+ " "+categoryOpt.get().getCategoryName());
		
		
		Category existingCategory = categoryOpt.get();
			
		categoryRepository.delete(existingCategory);
		
		return existingCategory;

		  
	}

	@Override
	public Category viewCategory(String name) {
		Optional<Category> categoryOpt = categoryRepository.findByCategoryName(name);
		
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
