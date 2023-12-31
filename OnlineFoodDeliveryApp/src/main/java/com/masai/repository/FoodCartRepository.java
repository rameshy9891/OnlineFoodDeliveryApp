package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.masai.model.FoodCart;

@Repository
public interface FoodCartRepository extends JpaRepository<FoodCart, Integer> {

}
