package com.masai.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.Item;

public interface ItemRepository extends JpaRepository<Item, Integer>{
	public Optional<Item> findByItemName(String name);
}
