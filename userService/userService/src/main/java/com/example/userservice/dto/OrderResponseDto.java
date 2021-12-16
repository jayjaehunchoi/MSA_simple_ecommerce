package com.example.userservice.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class OrderResponseDto {
    private String productId;
    private int quantity;
    private int unitPrice;
    private int totalPrice;
    private LocalDate createDate;

    private String orderId;
}
