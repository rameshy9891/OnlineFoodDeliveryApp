package com.masai.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerId;
	
	@NotNull(message = "name should be not notnull")
	@NotBlank(message = "name should be not not blank")
	@NotEmpty(message = "name should be not not empty")
	@Size(min=2 ,max=25 ,message = "name should be not null or not blank")
	private String firstName;
	
	@NotNull(message = "lastname should be not notnull")
	@NotBlank(message = "lastname should be not not blank")
	@NotEmpty(message = "lastname should be not not empty")
	@Size(min=2 ,max=25 ,message = "lastname should be not null or not blank")
	private String lastName;
	
	@NotNull(message = "age should be not notnull")
	@Size(min=18, max=100,message = "childe is not allowed")
	private Integer age;
	
	@NotNull(message = "gender should be not notnull")
	private Gender gender;
	
	@NotNull(message = "mobile number should be not notnull")
	@Size(min=10,max=13,message = "number +91 accepteble")
	private String mobileNumber;
	
	@Embedded
	private Address address;
	
	@Email(message = "email should be in proper formet")
	private String email;
	
	//optional
	
	@OneToOne(mappedBy = "customer",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private FoodCart foodCart;
	
	private String role;

}
