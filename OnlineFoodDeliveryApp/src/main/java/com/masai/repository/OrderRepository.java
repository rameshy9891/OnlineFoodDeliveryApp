package com.masai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.masai.model.Customer;
import com.masai.model.OrderDetails;
import com.masai.model.Restaurant;

@Repository
public interface OrderRepository extends JpaRepository<OrderDetails, Integer> {
	
//	@Query("SELECT o FROM OrderDetails o JOIN o.cart c JOIN c.items i WHERE i.restaurant = :restaurant")
//    List<OrderDetails> findAllByCart_Restaurant(Restaurant restaurant);
//
//    @Query("SELECT o FROM OrderDetails o WHERE o.cart.customer = :customer")
//    List<OrderDetails> findAllByCart_Customer(Customer customer);
    
}
