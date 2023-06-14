package com.masai.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.repository.query.parser.Part.IgnoreCaseType;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FoodCart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String cartId;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "customerId")
	private Customer customer;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private List<Item> itemList= new ArrayList<>();
	
	@OneToMany( mappedBy = "cart",cascade = CascadeType.ALL)
	
	private List<OrderDetails> orderList= new ArrayList<>() ;

}
