package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.FoodCartException;
import com.masai.model.FoodCart;
import com.masai.model.Item;
import com.masai.repository.FoodCartRepository;

@Service
public class ICartServiceImpl implements ICartService {
	
	@Autowired
	private FoodCartRepository foodCartRepository;
	
	@Override
	public FoodCart addItemToCart(Integer cartId, Item item) {
		
		Optional<FoodCart> opt = foodCartRepository.findById(cartId);
		
		FoodCart existedCart;
		
		if(opt.isPresent()) {
			
			existedCart = opt.get();
			
			existedCart.getItemList().add(item);
			
			existedCart = foodCartRepository.save(existedCart); // Save the updated FoodCart
			
		}else {
			throw new FoodCartException("Invalid FoodCartId");
		}
		
		return existedCart;
		
	}

	@Override
	public FoodCart increaseQuantity(Integer cartId, Integer itemId, Integer quantity) {
		
		Optional<FoodCart> opt = foodCartRepository.findById(cartId);
		
		if (opt.isPresent()) {
			
	        FoodCart existedCart = opt.get();
	        
	        // Find the item in the FoodCart's item list
	        Optional<Item> optItem = existedCart.getItemList().stream()
	                .filter(i -> i.getItemId().equals(itemId))
	                .findFirst();
		
	        if (optItem.isPresent()) {
	        	
	            Item existingItem = optItem.get();
	            
	            // Increase the quantity of the item
	            existingItem.setQuantity(existingItem.getQuantity() + quantity);
	            
	        } else {
	        	
	            throw new FoodCartException("Invalid ItemId");
	            
	        }
	        
	        // Save the updated FoodCart in the repository
	        return foodCartRepository.save(existedCart);
	        
	    } else {
	        throw new FoodCartException("Invalid FoodCartId");
	    }
	        
	}

	@Override
	public FoodCart reduceQuantity(Integer cartId, Integer itemId, Integer quantity) {
		
		Optional<FoodCart> opt = foodCartRepository.findById(cartId);
		
		if (opt.isPresent()) {
			
	        FoodCart existedCart = opt.get();
	        
	        // Find the item in the FoodCart's item list
	        Optional<Item> optItem = existedCart.getItemList().stream()
	                .filter(i -> i.getItemId().equals(itemId))
	                .findFirst();
		
	        if (optItem.isPresent()) {
	        	
	            Item existingItem = optItem.get();
	            
	            // Increase the quantity of the item
	            existingItem.setQuantity(existingItem.getQuantity() - quantity);
	            
	        } else {
	        	
	            throw new FoodCartException("Invalid ItemId");
	            
	        }
	        
	        // Save the updated FoodCart in the repository
	        return foodCartRepository.save(existedCart);
	        
	    } else {
	        throw new FoodCartException("Invalid FoodCartId");
	    }
	}

	@Override
	public FoodCart removeItem(Integer cartId, Integer itemId) {
		
		FoodCart existedCart = foodCartRepository.findById(cartId)
								.orElseThrow(() -> new FoodCartException("Invalid FoodCartId"));
		
		List<Item> itemList = existedCart.getItemList();
	    itemList.removeIf(item -> item.getItemId().equals(itemId));   //removing item from list
	    
	    existedCart = foodCartRepository.save(existedCart); // Save the updated FoodCart
	    
	    return existedCart;
	}

	@Override
	public FoodCart clearCart(Integer cartId) {
		
		FoodCart existedCart = foodCartRepository.findById(cartId)
				.orElseThrow(() -> new FoodCartException("Invalid FoodCartId"));
		
		existedCart.getItemList().clear();  //clearing all items
		
		foodCartRepository.save(existedCart); // Save the updated FoodCart
		
		return  existedCart; 
	}

}
