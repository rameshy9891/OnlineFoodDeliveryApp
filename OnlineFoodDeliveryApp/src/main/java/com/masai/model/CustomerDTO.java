package com.masai.model;


import jakarta.persistence.Embedded;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO {
    
	   private String mobileNumber;
	   
	   @Embedded
	   private Address address;
	   
}
