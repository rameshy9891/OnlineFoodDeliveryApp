package com.masai.service;

import java.util.List;
import com.masai.model.Customer;
import com.masai.model.OrderDetails;
import com.masai.model.Restaurant;


public interface OrderService {
	
	public OrderDetails addOrder(OrderDetails order);
	
	public OrderDetails updateOrder(OrderDetails order);
	
	public OrderDetails removeOrder(OrderDetails order);
	
	public OrderDetails viewOrder(Integer orderId);
	
	public List<OrderDetails> viewAllOrdersByRestaurant(Restaurant res);
	
	public List<OrderDetails> viewAllOrdersByCustomer(Customer customer);
}
