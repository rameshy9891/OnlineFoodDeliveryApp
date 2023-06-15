package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.masai.service.IOrderService;

@Repository
public class OrderController {
	
	@Autowired
	private IOrderService iOrderService;
	
	
}
