package com.masai.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.Category;

public interface CategoryRepository extends JpaRepository<Category,Integer>{

	public Optional<Category> findByCategoryName(String name);
}
