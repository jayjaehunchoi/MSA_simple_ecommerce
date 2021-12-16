package com.example.catalogservice.web;

import lombok.Builder;
import lombok.Data;

@Data
public class CatalogRequestDto {
    private String productId;
    private int quantity;
    private int unitPrice;
    private int totalPrice;

    private Long orderId;
    private Long userId;

}
