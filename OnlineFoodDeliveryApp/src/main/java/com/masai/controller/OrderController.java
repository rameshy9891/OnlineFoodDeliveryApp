package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Customer;
import com.masai.model.OrderDetails;
import com.masai.model.Restaurant;
import com.masai.service.OrderService;

import jakarta.validation.Valid;

@RestController
public class OrderController {
	
	@Autowired
	private OrderService iOrderService;
	
	@PostMapping("/addOrder/{email}")
	public ResponseEntity<OrderDetails> addOrderHandler(@Valid @RequestBody OrderDetails order,
			@PathVariable("email") String email){
		
		OrderDetails placedOrder = iOrderService.addOrder(order,email);
		
		return new ResponseEntity<OrderDetails>(placedOrder,HttpStatus.CREATED);
	}
	
	//@PutMapping("/updateOrder")
	public ResponseEntity<OrderDetails> updateOrderHandler(@Valid @RequestBody OrderDetails order){
		
		OrderDetails updatedOrder = iOrderService.updateOrder(order);
		
		return new ResponseEntity<OrderDetails>(updatedOrder,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/cancelOrder/{orderId}")
	public ResponseEntity<OrderDetails> deleteOrderHandler(@PathVariable("orderId") Integer orderId){
		
		OrderDetails deletedOrder = iOrderService.removeOrder(orderId);
		
		return new ResponseEntity<OrderDetails>(deletedOrder,HttpStatus.CREATED);
	}
	
	@GetMapping("/order/{email}")
	public ResponseEntity<List<OrderDetails>> viewOrderHandler(@PathVariable("email") String email){
		
		List<OrderDetails> fetchedOrder = iOrderService.viewOrder(email);
		
		return new ResponseEntity<>(fetchedOrder,HttpStatus.OK);
	}
	
	//@GetMapping("/ordersByRestaurant")
	public ResponseEntity<List<OrderDetails>> viewAllOrderByRestaurantHandler(@Valid @RequestBody Restaurant res){
		
		List<OrderDetails> fetchedOrders = iOrderService.viewAllOrdersByRestaurant(res);
		
		return new ResponseEntity<List<OrderDetails>>(fetchedOrders,HttpStatus.OK);
	}
	
	//@GetMapping("/ordersByCustomer")
	public ResponseEntity<List<OrderDetails>> viewAllOrderByCustomerHandler(@Valid @RequestBody Customer customer){
		
		List<OrderDetails> fetchedOrders = iOrderService.viewAllOrdersByCustomer(customer);
		
		return new ResponseEntity<List<OrderDetails>>(fetchedOrders,HttpStatus.OK);
	}
}
