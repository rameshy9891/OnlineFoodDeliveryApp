package com.masai.model;

import java.time.LocalDateTime;

import jakarta.persistence.*;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderDetailId;

    @NotNull(message = "Order date is required")
    private LocalDateTime orderDate;

    @NotNull(message = "FoodCart is required")
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "foodcartId")
    private FoodCart cart;

    @NotBlank(message = "Order status should not be blank")
    private String orderStatus;

}
