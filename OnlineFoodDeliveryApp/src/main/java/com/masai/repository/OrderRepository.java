package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.model.OrderDetails;
@Repository
public interface OrderRepository extends JpaRepository<OrderDetails, Integer> {

}
