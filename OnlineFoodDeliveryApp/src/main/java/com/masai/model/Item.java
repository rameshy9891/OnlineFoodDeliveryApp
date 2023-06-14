package com.masai.model;

import java.util.List;

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
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer itemId;

    @NotBlank(message = "Item name should not be blank")
    @NotBlank(message = "Item name is required")
    private String itemName;

    @NotNull(message = "Category is required")
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "categoryId")
    private Category category;

    @NotNull(message = "Quantity is required")
    private Integer quantity;

    @NotNull(message = "Cost is required")
    private double cost;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "itemList")
    private List<Restaurant> restaurants;

}
