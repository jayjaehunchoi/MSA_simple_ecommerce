package com.example.orderservice.web;

import com.example.orderservice.domain.Order;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderResponseDto {

    private Long orderId;
    private String productId;
    private int quantity;
    private int unitPrice;
    private int totalPrice;
    private LocalDate createDate;


    @Builder
    public OrderResponseDto(Long orderId, String productId, int quantity, int unitPrice, LocalDate createDate) {
        this.orderId = orderId;
        this.productId = productId;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.totalPrice = quantity * unitPrice;
        this.createDate = createDate;
    }

    public static OrderResponseDto from(Order order) {
        return OrderResponseDto.builder()
                .orderId(order.getId())
                .productId(order.getProductId())
                .quantity(order.getQuantity())
                .unitPrice(order.getUnitPrice())
                .createDate(order.getCreateDate())
                .build();
    }
}
