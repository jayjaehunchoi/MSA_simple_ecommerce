package com.example.orderservice.web;

import com.example.orderservice.domain.Order;
import lombok.Data;

@Data
public class OrderRequestDto {
    private String productId;
    private int quantity;
    private int unitPrice;
    private int totalPrice;

    private Long userId;

    public Order toEntity() {
        return Order.builder()
                .productId(productId)
                .quantity(quantity)
                .unitPrice(unitPrice)
                .totalPrice(quantity * unitPrice)
                .userId(userId)
                .build();
    }
}
