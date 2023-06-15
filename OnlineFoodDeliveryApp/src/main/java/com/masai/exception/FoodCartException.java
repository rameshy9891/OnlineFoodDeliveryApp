package com.masai.exception;

public class FoodCartException extends RuntimeException {
	
	public FoodCartException() {
		super();
	}
	
	public FoodCartException(String msg) {
		super(msg);
	}
}
