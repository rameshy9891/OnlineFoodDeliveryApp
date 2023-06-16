package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.masai.model.Customer;
import com.masai.model.OrderDetails;
import com.masai.model.Restaurant;
import com.masai.service.IOrderService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

@Repository
public class OrderController {
	
	@Autowired
	private IOrderService iOrderService;
	
	@PostMapping("/addOrder")
	public ResponseEntity<OrderDetails> addOrderHandler(@Valid @RequestBody OrderDetails order){
		
		OrderDetails placedOrder = iOrderService.addOrder(order);
		
		return new ResponseEntity<OrderDetails>(placedOrder,HttpStatus.CREATED);
	}
	
	@PatchMapping("/updateOrder")
	public ResponseEntity<OrderDetails> updateOrderHandler(@Valid @RequestBody OrderDetails order){
		
		OrderDetails updatedOrder = iOrderService.updateOrder(order);
		
		return new ResponseEntity<OrderDetails>(updatedOrder,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/cancelOrder")
	public ResponseEntity<OrderDetails> deleteOrderHandler(@Valid @RequestBody OrderDetails order){
		
		OrderDetails deletedOrder = iOrderService.removeOrder(order);
		
		return new ResponseEntity<OrderDetails>(deletedOrder,HttpStatus.CREATED);
	}
	
	@GetMapping("/order/{orderId}")
	public ResponseEntity<OrderDetails> viewOrderHandler(@PathVariable("orderId") Integer orderid){
		
		OrderDetails fetchedOrder = iOrderService.viewOrder(orderid);
		
		return new ResponseEntity<OrderDetails>(fetchedOrder,HttpStatus.CREATED);
	}
	
	@GetMapping("/ordersByRestaurant")
	public ResponseEntity<List<OrderDetails>> viewAllOrderByRestaurantHandler(@Valid @RequestBody Restaurant res){
		
		List<OrderDetails> fetchedOrders = iOrderService.viewAllOrdersByRestaurant(res);
		
		return new ResponseEntity<List<OrderDetails>>(fetchedOrders,HttpStatus.CREATED);
	}
	
	@GetMapping("/ordersByCustomer")
	public ResponseEntity<List<OrderDetails>> viewAllOrderByCustomerHandler(@Valid @RequestBody Customer customer){
		
		List<OrderDetails> fetchedOrders = iOrderService.viewAllOrdersByCustomer(customer);
		
		return new ResponseEntity<List<OrderDetails>>(fetchedOrders,HttpStatus.CREATED);
	}
}
