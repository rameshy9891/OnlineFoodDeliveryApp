package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.Item;

public interface ItemRepository extends JpaRepository<Item, Integer>{

}
