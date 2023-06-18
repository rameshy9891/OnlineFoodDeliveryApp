package com.masai.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
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

    @NotNull(message = "First name should not be null")
    @NotBlank(message = "First name should not be blank")
    @NotEmpty(message = "First name should not be empty")
    @Size(min = 2, max = 25, message = "First name should be between 2 and 25 characters")
    private String firstName;

    @NotNull(message = "Last name should not be null")
    @NotBlank(message = "Last name should not be blank")
    @NotEmpty(message = "Last name should not be empty")
    @Size(min = 2, max = 25, message = "Last name should be between 2 and 25 characters")
    private String lastName;

    @NotNull(message = "Age should not be null")
    @Min(value = 18, message = "Age must be a positive number")
    @Max(value = 100, message = "Age cannot exceed 100")
    private Integer age;

    @NotNull(message = "Gender should not be null")
    private Gender gender;

    @NotNull(message = "Mobile number should not be null")
    @Size(min = 10, max = 13, message = "Mobile number should be between 10 and 13 characters")
    private String mobileNumber;

    @Embedded
    private Address address;
    
    @Column(unique= true)
    @Email(message = "Email should be in proper format")
    private String email;
    
    @JsonProperty(access= JsonProperty.Access.WRITE_ONLY)
    //@Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{6,10}$",
    //message = "Password must contain at least one letter, one digit, and have a length between 6 and 10 characters")
    private String password;

    @JsonIgnore
    @OneToOne(mappedBy = "customer", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private FoodCart foodCart;

    @NotNull(message = "Role Must be Assigned")
    private String role;
}
