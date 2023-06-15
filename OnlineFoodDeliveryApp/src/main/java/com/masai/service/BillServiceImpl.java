package com.masai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.BillException;
import com.masai.model.Bill;
import com.masai.model.OrderDetails;
import com.masai.repository.BillRepository;
import com.masai.repository.OrderRepository;

@Service
public class BillServiceImpl implements BillService{
  
	@Autowired
	private BillRepository billRepository;
	
	@Autowired
	private OrderRepository orderRepository;


	@Override
	public Bill addBill(Bill bill, Integer orderId) {
		
		if(bill==null) {
			throw new BillException("bill details should not null");
		}
		OrderDetails order = orderRepository.findById(orderId).orElseThrow(()-> new BillException("No Order present with this Order Id"));
         
		bill.setOrder(order);
		
		return billRepository.save(bill);
	}
	
	
}
