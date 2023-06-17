package com.masai.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.OrderException;
import com.masai.model.Customer;
import com.masai.model.FoodCart;
import com.masai.model.OrderDetails;
import com.masai.model.Restaurant;
import com.masai.repository.FoodCartRepository;
import com.masai.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	
	 @Autowired
	 private FoodCartRepository foodCartRepository;
	
	@Override
	public OrderDetails addOrder(OrderDetails order) {
		
		OrderDetails savedOrder; 
		
		if(order != null) {
			
			FoodCart cart = order.getCart();
			
	        cart.getOrderList().add(order); // Add order to the food cart
	        order.setCart(cart); // Set the food cart in the order
	        
			savedOrder = orderRepository.save(order);
			
		}else {
			throw new OrderException("Order can not be null");
		}
		
		return savedOrder;
	}

	@Override
	public OrderDetails updateOrder(OrderDetails order) {
		
		OrderDetails updatedOrder; 
		
		if(order != null) {
			
			updatedOrder = orderRepository.findById(order.getOrderDetailId())
					.orElseThrow(()->new OrderException("Order is not present with this id"));
			
			FoodCart cart = order.getCart();
			
	        cart.getOrderList().add(order); // Add order to the food cart
	        order.setCart(cart); // Set the food cart in the order
			
		}else {
			throw new OrderException("Order can not be null");
		}
		
		return  orderRepository.save(order);
	}

	@Override
	public OrderDetails removeOrder(OrderDetails order) {
		
		FoodCart cart = order.getCart();
        
		cart.getOrderList().remove(order); // Remove order from the food cart
        
		order.setCart(null); // Set the food cart as null in the order
        
        foodCartRepository.save(cart); // Update the food cart
        
        orderRepository.delete(order);
        
        return order;
	}

	@Override
	public OrderDetails viewOrder(Integer orderId) {
		
		OrderDetails order = orderRepository.findById(orderId)
				.orElseThrow( ()-> new OrderException("Invalid Order Id"));
		
		return order;
	}

	@Override
	public List<OrderDetails> viewAllOrdersByRestaurant(Restaurant res) {
		
		//return orderRepository.findAllByCart_Restaurant(res);
		return null;
	}

	@Override
	public List<OrderDetails> viewAllOrdersByCustomer(Customer customer) {
		
		//return orderRepository.findAllByCart_Customer(customer);
	  return null;
	}

}
