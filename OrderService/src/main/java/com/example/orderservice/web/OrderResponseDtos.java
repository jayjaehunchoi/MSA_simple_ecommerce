package com.example.orderservice.web;

import lombok.Data;

import java.util.List;

@Data
public class OrderResponseDtos {

    private List<OrderResponseDto> orders;

    public OrderResponseDtos(List<OrderResponseDto> orders) {
        this.orders = orders;
    }
}
