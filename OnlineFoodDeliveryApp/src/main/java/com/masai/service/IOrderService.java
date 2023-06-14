package com.masai.service;

import java.util.List;

import com.masai.model.Customer;
import com.masai.model.OrderDetails;
import com.masai.model.Restaurant;

public interface IOrderService {
	
	public OrderDetails addOrder(OrderDetails order);
	
	public OrderDetails updateOrder(OrderDetails order);
	
	public OrderDetails removeOrder(OrderDetails order);
	
	public OrderDetails viewOrder(OrderDetails order);
	
	public List<OrderDetails> viewAllOrders(Restaurant res);
	
	public List<OrderDetails> viewAllOrders(Customer customer);
	
}
