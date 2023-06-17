package com.masai.service;

import java.util.List;

import com.masai.model.Category;

public interface CategoryService {
 
	public Category addCategory(Category cat);
	public Category updateCategory(Category cat); 
	public Category removeCategory(Integer catId);
	public Category viewCategory(String catName);
	public List<Category> viewAllCategory();
}
