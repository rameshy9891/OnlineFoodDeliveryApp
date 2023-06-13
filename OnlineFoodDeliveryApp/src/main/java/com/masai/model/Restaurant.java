package com.masai.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Restaurant {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer restaurantId;
	
	private String restaurantName;
	
	@Embedded
	private Address address;
	
	@ManyToMany(  fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinTable(name = "restaurant_Item_Table",joinColumns = @JoinColumn(name="restaurantId"),inverseJoinColumns = @JoinColumn(name="itemId"))
	private List<Item> itemList;
	
	private String managerName;
	
	private String contactNumber;
	

}
