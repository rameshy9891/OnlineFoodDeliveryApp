package com.masai.exception;

public class OrderException extends RuntimeException {
	
	public OrderException() {
		super();
	}
	
	public OrderException(String msg) {
		super(msg);
	}
}
