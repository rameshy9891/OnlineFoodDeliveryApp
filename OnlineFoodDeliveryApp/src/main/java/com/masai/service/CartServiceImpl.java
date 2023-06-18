package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.CustomerException;
import com.masai.exception.FoodCartException;
import com.masai.exception.ItemException;
import com.masai.model.Customer;
import com.masai.model.FoodCart;
import com.masai.model.Item;
import com.masai.repository.CustomerRepository;
import com.masai.repository.FoodCartRepository;
import com.masai.repository.ItemRepository;

@Service
public class CartServiceImpl implements CartService {
	
	@Autowired
	private FoodCartRepository foodCartRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private ItemRepository itemRepository;
	
	@Override
	public FoodCart addItemToCart(String email, String name, Integer quantity) {
		if(email==null || name == null) throw new CustomerException("Please provide Valid data");
		
		Customer customer =customerRepository.findByEmail(email).orElseThrow(()-> new CustomerException("Not able to find Customer in database"));
		
		FoodCart existedCart =customer.getFoodCart();
		
	    Item item=	itemRepository.findByItemName(name).orElseThrow(()-> new ItemException("Invalid Item name"));
		item.setQuantity(quantity);
		existedCart.getItemList().add(item);
		

			//existedCart = foodCartRepository.save(existedCart); // Save the updated FoodCart
		customerRepository.save(customer);
		
		return existedCart;
		
	}

	@Override
	public FoodCart increaseQuantity(String email, String name, Integer quantity) {
		
if(email==null || name == null) throw new CustomerException("Please provide Valid data");
		
		Customer customer =customerRepository.findByEmail(email).orElseThrow(()-> new CustomerException("Not able to find Customer in database"));
		
		FoodCart existedCart =customer.getFoodCart();
		
	    Item item=	itemRepository.findByItemName(name).orElseThrow(()-> new ItemException("Invalid Item name"));
		
	        

	            item.setQuantity(item.getQuantity() + quantity);
	            
	        
	        
	       
	         customerRepository.save(customer);
	        return existedCart;
	    
	        
	}

	@Override
	public FoodCart reduceQuantity(String email, String name, Integer quantity) {
		
if(email==null || name == null) throw new CustomerException("Please provide Valid data");
		
		Customer customer =customerRepository.findByEmail(email).orElseThrow(()-> new CustomerException("Not able to find Customer in database"));
		
		FoodCart existedCart =customer.getFoodCart();
		
	    Item item=	itemRepository.findByItemName(name).orElseThrow(()-> new ItemException("Invalid Item name"));
		
	        

	            item.setQuantity(item.getQuantity() - quantity);
	            
	        
	        
	       
	         customerRepository.save(customer);
	        return existedCart;
	    
	}

	@Override
	public FoodCart removeItem(String email, String itemName) {
		
       if(email==null || itemName == null) throw new CustomerException("Please provide Valid data");
		
		Customer customer =customerRepository.findByEmail(email).orElseThrow(()-> new CustomerException("Not able to find Customer in database"));
		 
        FoodCart existedCart =customer.getFoodCart();
		
	    Item ite=	itemRepository.findByItemName(itemName).orElseThrow(()-> new ItemException("Invalid Item name"));
		

		
		List<Item> itemList = existedCart.getItemList();
	    itemList.removeIf(item -> item.getItemName().equals(itemName));   //removing item from list
	    
	     customerRepository.save(customer); // Save the updated FoodCart
	    
	    return existedCart;
	}

	@Override
	public FoodCart clearCart(String email) {
		  if(email==null ) throw new CustomerException("Please provide Valid data");
			
			Customer customer =customerRepository.findByEmail(email).orElseThrow(()-> new CustomerException("Not able to find Customer in database"));
			 
	        FoodCart existedCart =customer.getFoodCart();
			
		
		existedCart.getItemList().clear();  //clearing all items
		
		customerRepository.save(customer); // Save the updated FoodCart
		
		return  existedCart; 
	}

}
