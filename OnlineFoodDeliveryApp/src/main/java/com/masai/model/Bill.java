package com.masai.model;

import java.time.LocalDateTime;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer billId;

    @NotNull(message = "Bill date is required")
    private LocalDateTime billDate;

    @NotNull(message = "Order details are required")
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "orderDetailId")
    private OrderDetails order;

    @NotNull(message = "Total item count is required")
    @Positive(message = "Total item count must be a positive number")
    private Integer totalItem;

    @NotNull(message = "Total cost is required")
    @Positive(message = "Total cost must be a positive number")
    private Double totalCost;
}
